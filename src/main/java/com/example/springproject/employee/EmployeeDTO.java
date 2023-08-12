package com.example.springproject.employee;


import io.swagger.annotations.ApiModelProperty;

public class EmployeeDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)

    private String name;


    @ApiModelProperty(required = true, hidden = false)

    private String family;

    @ApiModelProperty(required = true, hidden = false)

    private String nationalCode;

    @ApiModelProperty(required = true, hidden = false)

    private Gender gender;


    @ApiModelProperty(required = true, hidden = false)
    private Long birthDay;


    @ApiModelProperty(required = true, hidden = false)

    private Boolean isMarried;

    @ApiModelProperty(required = false, hidden = true)

    private Integer childCount;

    public EmployeeDTO(Long id, String name, String family, String nationalCode, Gender gender, Long birthDay, Boolean isMarried, Integer childCount) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.nationalCode = nationalCode;
        this.gender = gender;
        this.birthDay = birthDay;
        this.isMarried = isMarried;
        this.childCount = childCount;
    }

    public EmployeeDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDay(Long birthDay) {
        this.birthDay = birthDay;
    }

    public void setIsMarried(Boolean isMarried) {
        this.isMarried = isMarried;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getFamily() {
        return this.family;
    }

    public String getNationalCode() {
        return this.nationalCode;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Long getBirthDay() {
        return this.birthDay;
    }

    public Boolean getIsMarried() {
        return this.isMarried;
    }

    public Integer getChildCount() {
        return this.childCount;
    }
}
