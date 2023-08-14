package com.example.springproject.post_employee;

import com.example.springproject.employee.EmployeeDTO;
import com.example.springproject.post.PostDTO;
import io.swagger.annotations.ApiModelProperty;

public class PostEmployeeDTO {
    @ApiModelProperty(required = false, hidden = true)
    private Long id;
    @ApiModelProperty(required = true, hidden = false)
    private PostDTO post;
    @ApiModelProperty(required = true, hidden = false)
    private EmployeeDTO employee;

    public PostEmployeeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
