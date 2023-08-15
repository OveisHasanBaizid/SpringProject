package com.example.springproject.post_employee;

import com.example.springproject.common.BaseEntity;
import com.example.springproject.employee.Employee;
import com.example.springproject.post.Post;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_postemployee",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"post_id", "employee_id"})})
public class PostEmployee extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public PostEmployee() {
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
