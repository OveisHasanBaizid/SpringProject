package com.example.springproject.family;

import com.example.springproject.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    List<Family> findAllByEmployee_Id(Long id);

}
