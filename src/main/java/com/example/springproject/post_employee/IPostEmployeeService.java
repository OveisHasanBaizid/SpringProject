package com.example.springproject.post_employee;

import java.util.List;

public interface IPostEmployeeService {
    PostEmployee save(PostEmployee postEmployee);

    void delete(Long id);

    PostEmployee getById(Long id);

    List<PostEmployee> findAll();

    List<PostEmployee> getAllByEmployee(Long empId);

    List<PostEmployee> getAllByPost(Long empId);
}
