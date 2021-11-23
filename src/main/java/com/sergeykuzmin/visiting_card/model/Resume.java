package com.sergeykuzmin.visiting_card.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resume")
@Validated
@Proxy(lazy = false)
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 4, max = 25, message = "Name  should be between 4 and 25 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Family_name should not be empty")
    @Size(min = 4, max = 25, message = "Family_name  should be between 4 and 25 characters")
    @Column(name = "family_name")
    private String familyName;

    @NotEmpty(message = "Patronymic should not be empty")
    @Size(min = 4, max = 25, message = "Patronymic  should be between 4 and 25 characters")
    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate ;


    @Column(name = "phone_number")
    private String phoneNumber;

    @NotEmpty(message = "email should not be empty")
    @Email(message = "email should be valid")
    @Column(name = "email")
    private String email;

    @DecimalMin(value = "12000.0", inclusive = false, message = "Price be greater than 12000")
    @Column(name = "expected_salary")
    private BigDecimal expectedSalary;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "resume_id" )
    private List<Education> educations;


    public void addEducation(Education education) {
        if (education == null) {
            educations = new ArrayList<>();
        }
        educations.add(education);
    }

    public Resume() {
    }

    public Resume(String firstName, String familyName, String patronymic, Gender gender, LocalDate birthDate,
                  String phoneNumber, String email, BigDecimal expectedSalary) {
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
