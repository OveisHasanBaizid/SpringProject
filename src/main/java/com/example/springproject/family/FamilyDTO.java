package com.example.springproject.family;

import com.example.springproject.common.exception.BaseDTO;
import com.example.springproject.employee.EmployeeDTO;
import io.swagger.annotations.ApiModelProperty;

public class FamilyDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private String fullName;

    @ApiModelProperty(required = true, hidden = false)
    private String nationalCode;

    @ApiModelProperty(required = true, hidden = false)
    private EmployeeDTO employee;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
