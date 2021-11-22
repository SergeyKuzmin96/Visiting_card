package com.sergeykuzmin.visiting_card.model;

import javax.persistence.*;

@Entity
@Table(name = "educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private TypeOfEducation type;

    @Column(name = "organization")
    private String organization;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "year")
    private int year;



}
