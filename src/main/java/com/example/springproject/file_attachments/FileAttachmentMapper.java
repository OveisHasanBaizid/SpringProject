package com.example.springproject.file_attachments;

import com.example.springproject.employee.EmployeeMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface FileAttachmentMapper {

    FileAttachment toFileAttachment(FileAttachmentDTO fileAttachmentDTO);

    FileAttachmentDTO toFileAttachmentDTO(FileAttachment fileAttachment);

    List<FileAttachment> toFileAttachmentList(List<FileAttachmentDTO> fileAttachmentDTOs);

    List<FileAttachmentDTO> toFileAttachmentDTOs(List<FileAttachment> fileAttachments);

}
