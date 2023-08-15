package com.example.springproject.post;

import com.example.springproject.common.exception.BaseDTO;
import io.swagger.annotations.ApiModelProperty;

public class PostDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private String title;

    public PostDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
