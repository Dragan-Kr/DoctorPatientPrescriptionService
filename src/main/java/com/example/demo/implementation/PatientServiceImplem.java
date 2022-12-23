package com.example.demo.implementation;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImplem implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient getPatientById(Integer pid) {
        return patientRepository.getById(pid);
    }
}
