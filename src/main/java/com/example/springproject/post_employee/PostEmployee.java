package com.example.springproject.post_employee;

import com.example.springproject.employee.Employee;
import com.example.springproject.post.Post;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_postemployee",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"post_id", "employee_id"})})
public class PostEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public PostEmployee(Long id, Post post, Employee employee) {
        this.id = id;
        this.post = post;
        this.employee = employee;
    }

    public PostEmployee(Post post, Employee employee) {
        this.post = post;
        this.employee = employee;
    }

    public PostEmployee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
