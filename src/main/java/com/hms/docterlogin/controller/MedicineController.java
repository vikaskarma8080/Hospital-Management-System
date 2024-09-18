package com.hms.docterlogin.controller;

import com.hms.docterlogin.entities.Medicine;
import com.hms.docterlogin.reposetories.MedicineRepository;
import com.hms.entites.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    public MedicineController(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @PostMapping("/insert")
    public Medicine createMedicine(@RequestBody Medicine medicine){
        return medicineRepository.save(medicine);
    }

    @GetMapping("/get")
    public List<Medicine> getAllMedicine()
    {
        return medicineRepository.findAll();
    }
}
