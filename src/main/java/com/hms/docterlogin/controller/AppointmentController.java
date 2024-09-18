package com.hms.docterlogin.controller;

import com.hms.docterlogin.entities.Appointment;
import com.hms.docterlogin.reposetories.AppointmentRepository;
import com.hms.entites.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class AppointmentController {

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping("/insert")
    public Appointment createAppointment(@RequestBody Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/get")
    public List<Appointment> getAllAppointment()
    {
        return appointmentRepository.findAll();
    }
}
