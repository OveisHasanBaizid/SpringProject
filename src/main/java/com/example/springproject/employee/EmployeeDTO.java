package com.example.springproject.employee;

import com.example.springproject.common.exception.BaseDTO;
import io.swagger.annotations.ApiModelProperty;

public class EmployeeDTO extends BaseDTO {
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

    public EmployeeDTO() {
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
