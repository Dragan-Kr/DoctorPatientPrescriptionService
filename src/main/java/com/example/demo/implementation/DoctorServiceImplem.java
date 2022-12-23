package com.example.demo.implementation;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.DoctorPK;
import com.example.demo.repositories.DoctorRepository;
import com.example.demo.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImplem implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public Doctor getById(DoctorPK doctorPK) {
        return doctorRepository.getById(doctorPK);
    }

    @Override
    public Doctor getDoctorById(Integer docid, Integer warid) {
        return doctorRepository.getById(new DoctorPK(docid,warid));
    }

    @Override
    public Doctor findDoctorById(DoctorPK doctorPK) {
        return doctorRepository.getById(doctorPK);
    }


}
