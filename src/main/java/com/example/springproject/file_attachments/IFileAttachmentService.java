package com.example.springproject.file_attachments;

import java.util.List;

public interface IFileAttachmentService {
    FileAttachment save(FileAttachment fileAttachment);

    void delete(Long id);

    FileAttachment getById(Long id);

    List<FileAttachment> getAll();

    FileAttachment getByEmployeeId(Long empId);

}
