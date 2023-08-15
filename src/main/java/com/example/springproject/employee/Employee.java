package com.example.springproject.employee;


import com.example.springproject.common.BaseEntity;
import com.example.springproject.file_attachments.FileAttachment;
import com.example.springproject.family.Family;
import com.example.springproject.post_employee.PostEmployee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_employee")
public class Employee extends BaseEntity {
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

    @OneToOne(fetch = FetchType.LAZY,mappedBy ="employee",cascade = CascadeType.ALL)
    private FileAttachment fileAttachment;

    public Employee() {
    }

    public Boolean getMarried() {
        return isMarried;
    }

    public void setMarried(Boolean married) {
        isMarried = married;
    }

    public List<Family> getFamilies() {
        return families;
    }

    public void setFamilies(List<Family> families) {
        this.families = families;
    }

    public List<PostEmployee> getPostEmployeeList() {
        return postEmployeeList;
    }

    public void setPostEmployeeList(List<PostEmployee> postEmployeeList) {
        this.postEmployeeList = postEmployeeList;
    }

    public FileAttachment getFileAttachment() {
        return fileAttachment;
    }

    public void setFileAttachment(FileAttachment fileAttachment) {
        this.fileAttachment = fileAttachment;
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
