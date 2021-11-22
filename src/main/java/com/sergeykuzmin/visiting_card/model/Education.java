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

    @Column(name = "facility")
    private String facility;

    @Column(name = "direction")
    private String direction;

}
