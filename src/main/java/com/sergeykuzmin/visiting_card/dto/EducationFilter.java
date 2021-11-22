package com.sergeykuzmin.visiting_card.dto;

import com.sergeykuzmin.visiting_card.model.TypeOfEducation;

import javax.persistence.Column;

public class EducationFilter {

    private TypeOfEducation type;

    private String organization;

    private String specialization;

    private int year;

    private Integer pageNumber;

    private Integer pageSize;

    private String sortDirectional;

    private String sortBy ;

    public EducationFilter(TypeOfEducation type, String organization, String specialization, int year, Integer pageNumber, Integer pageSize, String sortDirectional, String sortBy) {
        this.type = type;
        this.organization = organization;
        this.specialization = specialization;
        this.year = year;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortDirectional = sortDirectional;
        this.sortBy = sortBy;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortDirectional() {
        return sortDirectional;
    }

    public void setSortDirectional(String sortDirectional) {
        this.sortDirectional = sortDirectional;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
