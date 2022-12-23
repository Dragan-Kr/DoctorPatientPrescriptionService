package com.example.demo.services;

import com.example.demo.dtos.PrescriptionDto;
import com.example.demo.entities.Prescription;

import java.util.Collection;

public interface PrescriptionService {
    Collection<Prescription> findAllObjects();

    Prescription getPrescriptionById(Integer id);

    PrescriptionDto createPrescription(PrescriptionDto prescriptionDto);

    PrescriptionDto update(PrescriptionDto prescriptionDto, Integer id);

    void deleteById(Integer id);
}
