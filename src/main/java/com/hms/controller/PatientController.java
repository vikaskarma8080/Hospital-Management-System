package com.hms.controller;

import com.hms.docterlogin.entities.Appointment;
import com.hms.entites.Patient;
import com.hms.reposetories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        super();
        this.patientRepository = patientRepository;
    }

    @PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }


    @DeleteMapping("/patient/{id}")
    public ResponseEntity<Map<String,Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException {
        Patient patient= patientRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("patient not found with id "+id));
        patientRepository.delete(patient);

        Map<String,Boolean> response=new HashMap<String,Boolean>();
        response.put("Deleted" , Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}