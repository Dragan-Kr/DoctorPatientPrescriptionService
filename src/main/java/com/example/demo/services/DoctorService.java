package com.example.demo.services;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.DoctorPK;

public interface DoctorService {

    Doctor getById(DoctorPK doctorPK);

    Doctor getDoctorById(Integer docid, Integer warid);

    Doctor findDoctorById(DoctorPK doctorPK);
}
