package com.hms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;

@SpringBootApplication
public class HospitalManagementSystemApplication {

    public static void main(String[] args) {
        System.out.println("this is main class");
        SpringApplication.run(HospitalManagementSystemApplication.class, args);
    }

}
