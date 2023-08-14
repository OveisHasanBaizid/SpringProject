package com.example.springproject.post;

import com.example.springproject.employee.Employee;
import com.example.springproject.post_employee.PostEmployee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "tbl_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "post" ,cascade = CascadeType.ALL)
    private List<PostEmployee> postEmployeeList;

    public Post(Long id, String title, List<PostEmployee> postEmployeeList) {
        this.id = id;
        this.title = title;
        this.postEmployeeList = postEmployeeList;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
