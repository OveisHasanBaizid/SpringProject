package com.example.springproject.post_employee;

import com.example.springproject.employee.Employee;
import com.example.springproject.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostEmployeeRepository extends JpaRepository<PostEmployee, Long> {
    List<PostEmployee> findAllByEmployee(Employee employee);
    List<PostEmployee> findAllByPost(Post post);
}
