package com.example.springproject.file_attachments;

import com.example.springproject.employee.EmployeeDTO;
import io.swagger.annotations.ApiModelProperty;
public class FileAttachmentDTO {
    @ApiModelProperty(required = false, hidden = true)
    private Long id;
    @ApiModelProperty(required = true, hidden = false)
    private String personalImage;
    @ApiModelProperty(required = true, hidden = false)
    private String lastLicenseImage;
    @ApiModelProperty(required = true, hidden = false)
    private EmployeeDTO employee;

    public FileAttachmentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
