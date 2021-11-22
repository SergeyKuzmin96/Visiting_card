package com.sergeykuzmin.visiting_card.service;

import com.sergeykuzmin.visiting_card.model.Resume;
import com.sergeykuzmin.visiting_card.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    private final ResumeRepository repository;

    @Autowired
    public ResumeService(ResumeRepository repository) {
        this.repository = repository;
    }

    public Resume saveResume(Resume resume){
        if(repository.getCount() == 0 || resume.getId().equals(getResume().getId())){
            return repository.save(resume);
        }else{
            return getResume();
        }
    }

    public Resume getResume(){

        return repository.getById(1L);
    }



}
