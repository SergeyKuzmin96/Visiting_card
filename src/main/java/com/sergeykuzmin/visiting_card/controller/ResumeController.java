package com.sergeykuzmin.visiting_card.controller;

import com.sergeykuzmin.visiting_card.model.Resume;
import com.sergeykuzmin.visiting_card.service.ResumeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resume")
@Tag(name = "Резюме", description = "Доступ к резюме")
public class ResumeController {

    private final ResumeService service;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.service = resumeService;
    }

    @PostMapping()
    public Resume createResume(@RequestBody Resume resume) {
        return service.createResume(resume);
    }

    @GetMapping()
    public Resume getResume() {
        return service.getResume();
    }


}
