package com.example.springproject.file_attachments;

import com.example.springproject.common.BaseEntity;
import com.example.springproject.employee.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_file_attachments")
public class FileAttachment extends BaseEntity {
    @NotNull
    @Column(name = "personal_image")
    private String personalImage;


    @NotNull
    @Column(name = "last_license_image")
    private String lastLicenseImage;

    @OneToOne
    @JoinColumn(name = "employee_id", unique = true)
    private Employee employee;

    public FileAttachment() {
    }

    public String getPersonalImage() {
        return personalImage;
    }

    public void setPersonalImage(String personalImage) {
        this.personalImage = personalImage;
    }

    public String getLastLicenseImage() {
        return lastLicenseImage;
    }

    public void setLastLicenseImage(String lastLicenseImage) {
        this.lastLicenseImage = lastLicenseImage;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
