package com.example.springproject.post;

import com.example.springproject.common.BaseEntity;
import com.example.springproject.post_employee.PostEmployee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "tbl_post")
public class Post extends BaseEntity {
    @NotNull
    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostEmployee> postEmployeeList;

    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PostEmployee> getPostEmployeeList() {
        return postEmployeeList;
    }

    public void setPostEmployeeList(List<PostEmployee> postEmployeeList) {
        this.postEmployeeList = postEmployeeList;
    }
}
