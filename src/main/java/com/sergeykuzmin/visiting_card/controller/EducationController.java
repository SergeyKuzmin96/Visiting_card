package com.sergeykuzmin.visiting_card.controller;

import com.sergeykuzmin.visiting_card.dto.EducationFilter;
import com.sergeykuzmin.visiting_card.model.Education;
import com.sergeykuzmin.visiting_card.model.TypeOfEducation;
import com.sergeykuzmin.visiting_card.service.EducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resume/education")
@Tag(name = "Образование", description = "Доступ к списку образовательных программ")
public class EducationController {

    private final EducationService service;

    @Autowired
    public EducationController(EducationService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
            summary = "Получение списка образовательных программ",
            description = "Позволяет  получить список получение списка образовательных программ, согласно заданым параметрам"
    )
    public Page<Education> findEducation(@RequestParam(value = "type", required = false) @Parameter(description = "Тип образовательной программы") TypeOfEducation type,
                                         @RequestParam(value = "organization", required = false) @Parameter(description = "Аттестующия организация") String organization,
                                         @RequestParam(value = "specialization", required = false) @Parameter(description = "Специализация") String specialization,
                                         @RequestParam(value = "year", required = false) @Parameter(description = "Год окончания") Integer year,

                                         @RequestParam(value = "pageNumber", required = false) @Parameter(description = "Номер страницы") Integer pageNumber,
                                         @RequestParam(value = "pageSize", required = false) @Parameter(description = "Количество позиций на странице") Integer pageSize,
                                         @RequestParam(value = "sortDirectional", required = false) @Parameter(description = "Порядок сортировки") String sortDirectional,
                                         @RequestParam(value = "sortBy", required = false) @Parameter(description = "Атрибут сортировки(Возможна сортировка по типу и году окончания)") String sortBy) {

        EducationFilter filter = new EducationFilter(type, organization, specialization, year, pageNumber, pageSize, sortDirectional, sortBy);
        return service.getPageOfEducations(filter);
    }

    @PostMapping
    @Operation(
            summary = "Добавление образования",
            description = "Позволяет добавить в резюме образовательную программу"
    )
    public ResponseEntity createProgram(@RequestBody Education education){

        if(service.addEducation(education)){
            return new ResponseEntity<>(education, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Резюме отсутствует", HttpStatus.BAD_REQUEST);
    }

}
