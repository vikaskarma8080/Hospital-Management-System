package com.hms.controller;

import com.hms.entites.Patient;
import com.hms.reposetories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Patient createPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }
    @GetMapping("/get")
    public List<Patient> getAllPatient()
    {
        return patientRepository.findAll();
    }
}