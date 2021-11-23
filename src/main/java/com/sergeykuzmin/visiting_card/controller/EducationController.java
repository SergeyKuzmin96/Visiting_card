package com.sergeykuzmin.visiting_card.controller;

import com.sergeykuzmin.visiting_card.dto.EducationFilter;
import com.sergeykuzmin.visiting_card.model.Education;
import com.sergeykuzmin.visiting_card.model.TypeOfEducation;
import com.sergeykuzmin.visiting_card.service.EducationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/resume/education")
@Tag(name = "Образование", description = "Доступ к списку образовательных программ")
public class EducationController {

    private final static Logger logger = LoggerFactory.getLogger(EducationController.class);

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

    @PostMapping("/new")
    @Operation(
            summary = "Добавление образовательной программы",
            description = "Позволяет добавить в резюме образовательную программу"
    )
    public ResponseEntity createProgram(@RequestBody  @Valid Education education, BindingResult bindingResult){

        if(bindingResult.hasErrors()){

            logger.error("Переданны не валидные данные");
            return new ResponseEntity<>("Неверный формат данных", HttpStatus.BAD_REQUEST);
        }
        if(service.addEducation(education)){

            logger.info("Образовательная программа успешно добавлена");
            return new ResponseEntity<>(education, HttpStatus.CREATED);
        }

        logger.info("В базе данных отсутствует резюме");
        return new ResponseEntity<>("Резюме отсутствует", HttpStatus.BAD_REQUEST);
    }

}
