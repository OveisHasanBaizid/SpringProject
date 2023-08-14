package com.example.springproject.family;


import com.example.springproject.employee.EmployeeMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {EmployeeMapper.class})
public interface IFamilyMapper {
    Family toFamily(FamilyDTO familyDTO);
    FamilyDTO toFamilyDTO(Family family);

    List<Family> toFamilyList(List<FamilyDTO> familyDTOS);
    List<FamilyDTO> toFamilyDTOS(List<Family> families);
}
