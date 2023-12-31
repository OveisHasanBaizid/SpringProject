package com.example.springproject.file_attachments;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/file-attachment/")
public class FileAttachmentController {

    private final IFileAttachmentService service;
    private final FileAttachmentMapper mapper;
    public FileAttachmentController(IFileAttachmentService service, FileAttachmentMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @PostMapping("/v1")
    public ResponseEntity<Object>  save(@RequestBody FileAttachmentDTO fileAttachmentDTO) {
        FileAttachment fileAttachment = mapper.toFileAttachment(fileAttachmentDTO);
        service.save(fileAttachment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/v1/{id}")
    public ResponseEntity<FileAttachmentDTO> getById(@PathVariable Long id) {
        FileAttachment fileAttachment = service.getById(id);
        FileAttachmentDTO fileAttachmentDTO = mapper.toFileAttachmentDTO(fileAttachment);
        return ResponseEntity.ok(fileAttachmentDTO);
    }
    @GetMapping("/v1")
    public ResponseEntity<List<FileAttachmentDTO>> getAll() {
        List<FileAttachment> fileAttachments = service.getAll();
        List<FileAttachmentDTO> fileAttachmentDTOS = mapper.toFileAttachmentDTOs(fileAttachments);
        return ResponseEntity.ok(fileAttachmentDTOS);
    }
    @DeleteMapping("/v1/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/get-by-employee/{empId}")
    public ResponseEntity<FileAttachmentDTO> getByEmployeeId(@PathVariable Long empId) {
        FileAttachment fileAttachment = service.getByEmployeeId(empId);
        FileAttachmentDTO fileAttachmentDTO = mapper.toFileAttachmentDTO(fileAttachment);
        return ResponseEntity.ok(fileAttachmentDTO);
    }
}
