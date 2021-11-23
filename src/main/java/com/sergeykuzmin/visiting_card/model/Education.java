package com.sergeykuzmin.visiting_card.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Validated
@Table(name = "educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeOfEducation type;

    @NotEmpty(message = "Organization of product should not be empty")
    @Size(min = 4, max = 40, message = "Organization of product should be between 4 and 40 characters")
    @Column(name = "organization")
    private String organization;

    @NotEmpty(message = "Specialization of product should not be empty")
    @Size(min = 4, max = 40, message = "Specialization of product should be between 4 and 40 characters")
    @Column(name = "specialization")
    private String specialization;

    @Min(value = 2010, message = "Year should be between 2010 and 2021")
    @Max(value = 2021, message = "Year should be between 2010 and 2021")
    @Column(name = "year")
    private Integer year;

    public Education() {
    }

    public Education(TypeOfEducation type,
                     @NotEmpty(message = "Organization of product should not be empty") @Size(min = 4, max = 40, message = "Organization of product should be between 4 and 40 characters") String organization,
                     @NotEmpty(message = "Specialization of product should not be empty") @Size(min = 4, max = 40, message = "Specialization of product should be between 4 and 40 characters") String specialization,
                     @Min(value = 2010, message = "Year should be between 2010 and 2021") @Max(value = 2021, message = "Year should be between 2010 and 2021") Integer year) {
        this.type = type;
        this.organization = organization;
        this.specialization = specialization;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeOfEducation getType() {
        return type;
    }

    public void setType(TypeOfEducation type) {
        this.type = type;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
