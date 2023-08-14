package com.example.springproject.post_employee;


import com.example.springproject.employee.EmployeeMapper;
import com.example.springproject.post.PostMapper;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, PostMapper.class})
public interface PostEmployeeMapper {
    PostEmployee toPostEmployee(PostEmployeeDTO postEmployeeDTO);

    PostEmployeeDTO toPostEmployeeDTO(PostEmployee postEmployee);

    List<PostEmployee> toPostEmployeeList(List<PostEmployeeDTO> postEmployeeDTOS);

    List<PostEmployeeDTO> toPostEmployeeDTOs(List<PostEmployee> postEmployeeList);
}
