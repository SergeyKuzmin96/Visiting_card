package com.sergeykuzmin.visiting_card.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate ;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "expected_salary")
    private BigDecimal expectedSalary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "resume_id")
    private List<Skill> skills;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "resume_id")
    private List<Education> educations;

    public void addSkill(Skill skill) {
        if (skills == null) {
            skills = new ArrayList<>();
        }
        skills.add(skill);
    }

    public void addEducation(Education education) {
        if (education == null) {
            educations = new ArrayList<>();
        }
        educations.add(education);
    }

    public Resume() {
    }

    public Resume(String firstName, String familyName, String patronymic, Gender gender, LocalDate birthDate, String phoneNumber, String email, BigDecimal expectedSalary) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.expectedSalary = expectedSalary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(BigDecimal expectedSalary) {
        this.expectedSalary = expectedSalary;
    }
}
