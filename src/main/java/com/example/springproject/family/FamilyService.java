package com.example.springproject.family;

import com.example.springproject.common.exception.NotFoundException;
import com.example.springproject.employee.Employee;
import com.example.springproject.employee.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FamilyService implements IFamilyService {

    private final FamilyRepository repository;
    private final IEmployeeService employeeService;

    public FamilyService(FamilyRepository repository, IEmployeeService employeeService) {
        this.repository = repository;
        this.employeeService = employeeService;
    }

    @Override
    public Family save(Family family) {
        Long emp_id = family.getEmployee().getId();
        Employee employee = employeeService.getById(emp_id);
        family.setEmployee(employee);
        return repository.save(family);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Family getById(Long id) {
        Optional<Family> optionalFamily = repository.findById(id);
        if (optionalFamily.isEmpty())
            throw new NotFoundException("Not Found");
        return optionalFamily.get();
    }

    @Override
    public List<Family> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Family> getAllByEmployee_id(Long id) {
        return repository.findAllByEmployee_Id(id);
    }

}
