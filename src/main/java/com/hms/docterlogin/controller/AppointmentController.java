package com.hms.docterlogin.controller;

import com.hms.docterlogin.entities.Appointment;
import com.hms.docterlogin.reposetories.AppointmentRepository;
import com.hms.entites.Patient;
import org.hibernate.jpa.internal.util.PersistenceUtilHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin("*")
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

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointment()
    {
        return appointmentRepository.findAll();
    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteAppointment(@PathVariable long id) throws AttributeNotFoundException {
        Appointment appointment= appointmentRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Appointment not found with id "+id));
        appointmentRepository.delete(appointment);

        Map<String,Boolean> response=new HashMap<String,Boolean>();
        response.put("Deleted" , Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
