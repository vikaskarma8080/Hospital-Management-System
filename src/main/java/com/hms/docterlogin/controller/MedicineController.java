package com.hms.docterlogin.controller;

import com.hms.docterlogin.entities.Medicine;
import com.hms.docterlogin.reposetories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin("*")
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    public MedicineController(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @PostMapping("/insert")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @GetMapping("/medicines")
    public List<Medicine> getAllMedicine() {
        return medicineRepository.findAll();
    }

    @DeleteMapping("/medicine/{id}")
    public ResponseEntity<Map<String,Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException {
        Medicine medicine= medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("medicine not found with id "+id));
        medicineRepository.delete(medicine);

        Map<String,Boolean> response=new HashMap<String,Boolean>();
        response.put("Deleted" , Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
