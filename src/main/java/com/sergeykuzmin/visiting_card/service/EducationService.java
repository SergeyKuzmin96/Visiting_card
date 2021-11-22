package com.sergeykuzmin.visiting_card.service;

import com.querydsl.core.types.Predicate;
import com.sergeykuzmin.visiting_card.dto.EducationFilter;
import com.sergeykuzmin.visiting_card.model.Education;
import com.sergeykuzmin.visiting_card.model.Resume;
import com.sergeykuzmin.visiting_card.repository.EducationRepository;
import com.sergeykuzmin.visiting_card.util.QPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.sergeykuzmin.visiting_card.model.QEducation.education;

@Service
public class EducationService {

    private final EducationRepository repository;
    private final ResumeService resumeService;

    @Autowired
    public EducationService(EducationRepository repository, ResumeService resumeService) {
        this.repository = repository;

        this.resumeService = resumeService;
    }


    public boolean addEducation(Education education) {
        Resume resume = resumeService.getResume();
        if (resume != null) {
            resume.addEducation(education);
            resumeService.saveResume(resume);
            return true;
        }
        return false;
    }


    public Page<Education> getPageOfEducations(EducationFilter filter) {
        if(needPredicate(filter)){
            return repository.findAll(getPredicate(filter), getPagebale(filter));
        }
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

    private boolean needPredicate(EducationFilter filter){
        return filter.getYear() != null || filter.getSpecialization() != null || filter.getOrganization() != null || filter.getType() != null;
    }

    private Predicate getPredicate(EducationFilter filter) {

        return QPredicate.builder()
                .add(filter.getType(), education.type::eq)
                .add(filter.getOrganization(), education.organization::containsIgnoreCase)
                .add(filter.getSpecialization(), education.specialization::containsIgnoreCase)
                .add(filter.getYear(), education.year::eq)
                .buildAnd();
    }

}
