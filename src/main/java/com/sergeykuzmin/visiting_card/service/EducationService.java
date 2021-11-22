package com.sergeykuzmin.visiting_card.service;

import com.sergeykuzmin.visiting_card.dto.EducationFilter;
import com.sergeykuzmin.visiting_card.model.Education;
import com.sergeykuzmin.visiting_card.model.Resume;
import com.sergeykuzmin.visiting_card.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

    private final EducationRepository repository;

    @Autowired
    public EducationService(EducationRepository repository) {
        this.repository = repository;
    }

    public Education addEducation(Education education, Resume resume) {

        resume.addEducation(education);
        repository.save(education);

        return education;
    }

    public Page<Education> getPageOfEducations(EducationFilter filter) {


        return repository.findAll(getPagebale(filter));
    }


    private Pageable getPagebale(EducationFilter filter) {
        String sortBy;

        if (filter.getSortBy() != null && filter.getSortBy().equalsIgnoreCase("type")) {
            sortBy = "type";
        } else {
            sortBy = "year";
        }

        Sort.Direction direction;

        if (filter.getSortDirectional() != null && filter.getSortDirectional().equalsIgnoreCase("DESC")) {
            direction = Sort.Direction.DESC;
        } else {
            direction = Sort.Direction.ASC;
        }

        Integer pageN = 0;
        Integer pageS = 5;

        if (filter.getPageNumber() != null) {
            pageN = filter.getPageNumber();
        }
        if (filter.getPageSize() != null) {
            pageS = filter.getPageSize();
        }

        Sort sort = Sort.by(direction, sortBy);

        return PageRequest.of(pageN, pageS, sort);

    }

}
