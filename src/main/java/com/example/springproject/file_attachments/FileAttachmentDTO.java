package com.example.springproject.file_attachments;

import com.example.springproject.common.exception.BaseDTO;
import com.example.springproject.employee.EmployeeDTO;
import io.swagger.annotations.ApiModelProperty;

public class FileAttachmentDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private String personalImage;
    @ApiModelProperty(required = true, hidden = false)
    private String lastLicenseImage;
    @ApiModelProperty(required = true, hidden = false)
    private EmployeeDTO employee;

    public FileAttachmentDTO() {
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
