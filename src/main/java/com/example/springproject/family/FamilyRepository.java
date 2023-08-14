package com.example.springproject.family;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    List<Family> findAllByEmployee_Id(Long id);

}
