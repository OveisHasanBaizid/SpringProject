package com.example.springproject.employee;

import com.example.springproject.common.PagingData;
import com.example.springproject.common.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee/")
public class EmployeeController {

    private final IEmployeeService service;
    private final EmployeeMapper mapper;

    public EmployeeController(IEmployeeService service, EmployeeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = mapper.toEmployee(employeeDTO);
        service.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/v1/search")
    public ResponseEntity<List<EmployeeDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<Employee> employees = service.search(searchCriteria);
        return ResponseEntity.ok(mapper.toEmployeeDTOs(employees));
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = mapper.toEmployee(employeeDTO);

        service.save(employee);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id) {

        Employee employee = service.getById(id);
        EmployeeDTO employeeDTO = mapper.toEmployeeDTO(employee);
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        List<Employee> employeeList = service.getAll();
        List<EmployeeDTO> employeeDTOS = mapper.toEmployeeDTOs(employeeList);
        return ResponseEntity.ok(employeeDTOS);
    }

    @GetMapping("/v1/filter-married/{isMarried}")
    public ResponseEntity<List<EmployeeDTO>> filterByIsMarriesd(@PathVariable Boolean isMarried) {
        List<Employee> employeeList = service.filterByMarriaed(isMarried);
        List<EmployeeDTO> employeeDTOS = mapper.toEmployeeDTOs(employeeList);
        return ResponseEntity.ok(employeeDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<EmployeeDTO>> filterByIsMarriesd(@PathVariable Integer page, Integer size) {
        Page<Employee> employeePage = service.paging(page, size);
        int totalPage = employeePage.getTotalPages();
        List<Employee> data = employeePage.getContent();
        List<EmployeeDTO> employeeDTOS = mapper.toEmployeeDTOs(data);
        PagingData<EmployeeDTO> pagingData = new PagingData<>(totalPage, page, employeeDTOS);
        return ResponseEntity.ok(pagingData);
    }
}
