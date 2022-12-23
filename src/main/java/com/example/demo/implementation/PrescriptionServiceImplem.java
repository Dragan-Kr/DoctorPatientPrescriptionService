package com.example.demo.implementation;

import com.example.demo.dtos.PrescriptionDto;
import com.example.demo.entities.DoctorPK;
import com.example.demo.entities.Prescription;
import com.example.demo.repositories.PrescriptionRepository;
import com.example.demo.services.DiagnosisService;
import com.example.demo.services.DoctorService;
import com.example.demo.services.PatientService;
import com.example.demo.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PrescriptionServiceImplem implements PrescriptionService {


    @Autowired
    private PrescriptionRepository repository;

    @Autowired
    private DiagnosisService diagnosisService;


    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Override
    public Collection<Prescription> findAllObjects() {
        return repository.findAll();
    }

    @Override
    public Prescription getPrescriptionById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public PrescriptionDto createPrescription(PrescriptionDto prescriptionDto) {

        Prescription  newPrescription = new Prescription();
        newPrescription.setDiagid(prescriptionDto.getDiagid());
//        newPrescription.setDiagid(diagnosisService.getDiagnosisById(newPrescription.getDiagid()).getId());
        newPrescription.setMedicine(prescriptionDto.getMedicine());
        newPrescription.setPdate(prescriptionDto.getPdate());
        newPrescription.setPatient(patientService.getPatientById(prescriptionDto.getPid()));
        newPrescription.setDoctor(doctorService.findDoctorById(new DoctorPK(prescriptionDto.getDocid(), prescriptionDto.getWarid())));
        newPrescription = repository.save(newPrescription);

        PrescriptionDto mapped = new PrescriptionDto(newPrescription.getId(),newPrescription.getDiagid(),newPrescription.getDoctor().getId(),newPrescription.getDoctor().getWarid(),newPrescription.getPatient().getId(),newPrescription.getMedicine(),newPrescription.getPdate());
        return mapped;
    }

    @Override
    public PrescriptionDto update(PrescriptionDto prescription, Integer id) {
        Prescription updated = repository.findById(id).map(oldPrescription->{
            oldPrescription.setDiagid(prescription.getDiagid());
            oldPrescription.setMedicine(prescription.getMedicine());
            oldPrescription.setPdate(prescription.getPdate());
            oldPrescription.setPatient(patientService.getPatientById(prescription.getPid()));
            oldPrescription.setDoctor(doctorService.findDoctorById(new DoctorPK(prescription.getDocid(), prescription.getWarid())));
            return  repository.save(oldPrescription);
        }).get();
        PrescriptionDto mapped = new PrescriptionDto(updated.getId(), updated.getDiagid(),updated.getDoctor().getId(),updated.getDoctor().getWarid(),updated.getPatient().getId(),updated.getMedicine(),updated.getPdate());
        return mapped;
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }


}
