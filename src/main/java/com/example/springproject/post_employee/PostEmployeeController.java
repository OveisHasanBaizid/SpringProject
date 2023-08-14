package com.example.springproject.post_employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/post-employee/")
public class PostEmployeeController {

    private final IPostEmployeeService postEmployeeService;
    private final PostEmployeeMapper mapper;

    public PostEmployeeController(IPostEmployeeService postEmployeeService, PostEmployeeMapper mapper) {
        this.postEmployeeService = postEmployeeService;
        this.mapper = mapper;
    }

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody PostEmployeeDTO postEmployeeDTO) {
        PostEmployee postEmployee = mapper.toPostEmployee(postEmployeeDTO);
        postEmployeeService.save(postEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<PostEmployeeDTO> getById(@PathVariable Long id) {
        PostEmployee postEmployee = postEmployeeService.getById(id);
        PostEmployeeDTO postEmployeeDTO = mapper.toPostEmployeeDTO(postEmployee);
        return ResponseEntity.ok(postEmployeeDTO);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<PostEmployeeDTO>> getAll() {
        List<PostEmployee> postEmployeeList = postEmployeeService.findAll();
        List<PostEmployeeDTO> familyDTOS = mapper.toPostEmployeeDTOs(postEmployeeList);
        return ResponseEntity.ok(familyDTOS);
    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        postEmployeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/get-by-employee/{id}")
    public ResponseEntity<List<PostEmployeeDTO>> getByIdEmployeeId(@PathVariable Long id) {
        List<PostEmployee> postEmployeeList = postEmployeeService.getAllByEmployee(id);
        List<PostEmployeeDTO> postEmployeeDTOs = mapper.toPostEmployeeDTOs(postEmployeeList);
        return ResponseEntity.ok(postEmployeeDTOs);
    }

    @GetMapping("/v1/get-by-post/{id}")
    public ResponseEntity<List<PostEmployeeDTO>> getByIdPostId(@PathVariable Long id) {
        List<PostEmployee> postEmployeeList = postEmployeeService.getAllByPost(id);
        List<PostEmployeeDTO> postEmployeeDTOs = mapper.toPostEmployeeDTOs(postEmployeeList);
        return ResponseEntity.ok(postEmployeeDTOs);
    }
}
