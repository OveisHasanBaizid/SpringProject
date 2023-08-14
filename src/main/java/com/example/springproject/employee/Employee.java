package com.example.springproject.employee;


import com.example.springproject.family.Family;
import com.example.springproject.post_employee.PostEmployee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;


    @NotNull
    @Column(name = "family")
    private String family;


    @NotNull
    @Column(name = "national_code", unique = true)
    private String nationalCode;


    @NotNull
    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @NotNull
    @Column(name = "birth_day")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDay;


    @NotNull
    @Column(name = "married")
    private Boolean isMarried;

    @Column(name = "child_count")
    private Integer childCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Family> families;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "employee" ,cascade = CascadeType.ALL)
    private List<PostEmployee> postEmployeeList;

    public Employee(Long id, @NotNull String name, @NotNull String family, @NotNull String nationalCode, @NotNull Gender gender, @NotNull Date birthDay, @NotNull Boolean isMarried, Integer childCount) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.nationalCode = nationalCode;
        this.gender = gender;
        this.birthDay = birthDay;
        this.isMarried = isMarried;
        this.childCount = childCount;
    }

    public Employee() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setFamily(@NotNull String family) {
        this.family = family;
    }

    public void setNationalCode(@NotNull String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setGender(@NotNull Gender gender) {
        this.gender = gender;
    }

    public void setBirthDay(@NotNull Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setIsMarried(@NotNull Boolean isMarried) {
        this.isMarried = isMarried;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public Long getId() {
        return this.id;
    }

    public @NotNull String getName() {
        return this.name;
    }

    public @NotNull String getFamily() {
        return this.family;
    }

    public @NotNull String getNationalCode() {
        return this.nationalCode;
    }

    public @NotNull Gender getGender() {
        return this.gender;
    }

    public @NotNull Date getBirthDay() {
        return this.birthDay;
    }

    public @NotNull Boolean getIsMarried() {
        return this.isMarried;
    }

    public Integer getChildCount() {
        return this.childCount;
    }
}
