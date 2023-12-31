package com.example.springproject.family;

import com.example.springproject.common.BaseEntity;
import com.example.springproject.employee.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_family" , uniqueConstraints = {@UniqueConstraint(columnNames = {"national_code", "employee_id"})})
public class Family extends BaseEntity {
    @NotNull
    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @Column(name = "national_code")
    private String nationalCode;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Family(Long id, String fullName, String nationalCode, Employee employee) {
        this.fullName = fullName;
        this.nationalCode = nationalCode;
        this.employee = employee;
    }
    public Family() {

    }
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
