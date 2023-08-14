package com.example.springproject.family;

import java.util.List;

public interface IFamilyService{
    Family save(Family family);

    void delete(Long id);

    Family getById(Long id);

    List<Family> findAll();

    List<Family> getAllByEmployee_id(Long id);
}
