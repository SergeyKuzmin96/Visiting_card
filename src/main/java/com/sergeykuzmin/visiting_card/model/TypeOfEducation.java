package com.sergeykuzmin.visiting_card.model;

public enum TypeOfEducation {
    UNIVERSITY("Высшее образование"),
    COURSES("Курсы");

    private String name;

    TypeOfEducation(String name) {
        this.name = name;
    }
}
