package com.example.springproject.file_attachments;

import com.example.springproject.common.exception.NotFoundException;
import com.example.springproject.employee.Employee;
import com.example.springproject.employee.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileAttachmentService implements IFileAttachmentService {
    private final FileAttachmentRepository repository;
    private final IEmployeeService employeeService;

    public FileAttachmentService(FileAttachmentRepository repository, IEmployeeService employeeService) {
        this.repository = repository;
        this.employeeService = employeeService;
    }

    @Override
    public FileAttachment save(FileAttachment fileAttachment) {
        Long empId = fileAttachment.getEmployee().getId();
        Employee employee = employeeService.getById(empId);
        fileAttachment.setEmployee(employee);
        return repository.save(fileAttachment);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public FileAttachment getById(Long id) {
        Optional<FileAttachment> optionalFileAttachment = repository.findById(id);
        if (optionalFileAttachment.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
        return optionalFileAttachment.get();
    }

    @Override
    public List<FileAttachment> getAll() {
        return repository.findAll();
    }

    @Override
    public FileAttachment getByEmployeeId(Long empId) {
        Employee emp = employeeService.getById(empId);
        return repository.findByEmployee(emp);
    }

}
