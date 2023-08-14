package com.example.springproject.post_employee;

import com.example.springproject.common.exception.NotFoundException;
import com.example.springproject.employee.Employee;
import com.example.springproject.employee.IEmployeeService;
import com.example.springproject.post.IPostService;
import com.example.springproject.post.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostEmployeeService implements IPostEmployeeService {
    private final PostEmployeeRepository postEmployeeRepository;
    private final IPostService postService;
    private final IEmployeeService employeeService;

    public PostEmployeeService(PostEmployeeRepository postEmployeeRepository
            , IPostService postService, IEmployeeService employeeService) {
        this.postEmployeeRepository = postEmployeeRepository;
        this.postService = postService;
        this.employeeService = employeeService;
    }

    @Override
    public PostEmployee save(PostEmployee postEmployee) {
        Long empId = postEmployee.getEmployee().getId();
        Long postId = postEmployee.getPost().getId();

        Employee employee = employeeService.getById(empId);
        Post post = postService.getById(postId);

        postEmployee.setEmployee(employee);
        postEmployee.setPost(post);
        return postEmployeeRepository.save(postEmployee);
    }

    @Override
    public void delete(Long id) {
        postEmployeeRepository.deleteById(id);
    }

    @Override
    public PostEmployee getById(Long id) {
        Optional<PostEmployee> optionalPostEmployee = postEmployeeRepository.findById(id);
        if (optionalPostEmployee.isEmpty())
            throw new NotFoundException("Not Found");
        return optionalPostEmployee.get();
    }

    @Override
    public List<PostEmployee> findAll() {
        return postEmployeeRepository.findAll();
    }

    @Override
    public List<PostEmployee> getAllByEmployee(Long empId) {
        Employee employee = employeeService.getById(empId);
        return postEmployeeRepository.findAllByEmployee(employee);
    }

    @Override
    public List<PostEmployee> getAllByPost(Long postId) {
        Post post = postService.getById(postId);
        return postEmployeeRepository.findAllByPost(post);
    }
}
