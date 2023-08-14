package com.example.springproject.family;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/family/")
public class FamilyController {

    private final IFamilyService service;
    private final FamilyMapper mapper;

    public FamilyController(IFamilyService service, FamilyMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody FamilyDTO familyDTO) {
        Family family = mapper.toFamily(familyDTO);
        service.save(family);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<FamilyDTO> getById(@PathVariable Long id) {
        Family family = service.getById(id);
        FamilyDTO familyDTO = mapper.toFamilyDTO(family);
        return ResponseEntity.ok(familyDTO);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<FamilyDTO>> getAll() {
        List<Family> families = service.findAll();
        List<FamilyDTO> familyDTOS = mapper.toFamilyDTOS(families);
        return ResponseEntity.ok(familyDTOS);
    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/get-by-employee/{id}")
    public ResponseEntity<List<FamilyDTO>> getByIdEmployee(@PathVariable Long id) {
        List<Family> families = service.getAllByEmployee_id(id);
        List<FamilyDTO> familyDTOS = mapper.toFamilyDTOS(families);
        return ResponseEntity.ok(familyDTOS);
    }
}
