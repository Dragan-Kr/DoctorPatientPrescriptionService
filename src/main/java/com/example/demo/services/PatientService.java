package com.example.demo.services;

import com.example.demo.entities.Patient;

public interface PatientService {
    Patient getPatientById(Integer pid);
}
