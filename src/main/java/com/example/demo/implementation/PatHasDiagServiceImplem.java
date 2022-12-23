package com.example.demo.implementation;

import com.example.demo.dtos.DocGivesDiagDto;
import com.example.demo.dtos.PatHasDiagDto;
import com.example.demo.entities.*;
import com.example.demo.repositories.PatHasDiagRepository;
import com.example.demo.services.DiagnosisService;
import com.example.demo.services.PatHasDiagSerice;
import com.example.demo.services.PatientService;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PatHasDiagServiceImplem implements PatHasDiagSerice {

    @Autowired
    private PatHasDiagRepository repository;

    @Autowired
    private PersonService personService;

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private PatientService patientService;


    @Override
    public Collection<Pathasdiag> findAllObjects() {
   return repository.findAll();
    }

    @Override
    public PatHasDiagDto getPatHasDiagById(Integer pid, Integer diagid) {
        Pathasdiag foundPathasdiag = repository.findById(new PathasdiagPK(pid,diagid)).get();
        foundPathasdiag.setPid((personService.getPersonById(foundPathasdiag.getPid())).getId());
        foundPathasdiag.setDiagid((diagnosisService.getDiagnosisById(foundPathasdiag.getDiagid())).getId());
        PatHasDiagDto mapped = new PatHasDiagDto(foundPathasdiag.getPid(),foundPathasdiag.getDiagid());
        return mapped;
    }

    @Override
    public PatHasDiagDto insert(PatHasDiagDto patHasDiagDto) {
        Pathasdiag newPathasdiag = new Pathasdiag();
        newPathasdiag.setPid(patHasDiagDto.getPid());
        newPathasdiag.setDiagid(patHasDiagDto.getDiagid());
        newPathasdiag.setPatient(patientService.getPatientById(patHasDiagDto.getPid()));
        newPathasdiag = repository.save(newPathasdiag);
        PatHasDiagDto mapped = new PatHasDiagDto(newPathasdiag.getPid(), newPathasdiag.getDiagid());
        return mapped;
    }

    @Override
    public PatHasDiagDto update(PatHasDiagDto patHasDiag, Integer pid, Integer diagid) {
        Pathasdiag updated = repository.findById(new PathasdiagPK(pid,diagid)).map(oldPatHasDiag ->{
            oldPatHasDiag.setPid(patHasDiag.getPid());
            oldPatHasDiag.setDiagid(patHasDiag.getDiagid());
            oldPatHasDiag.setPatient(patientService.getPatientById(patHasDiag.getPid()));
            return repository.save(oldPatHasDiag);
        }).get();

        PatHasDiagDto mapped = new PatHasDiagDto(updated.getPid(), updated.getDiagid());
        return mapped;
    }

    @Override
    public Pathasdiag create(Pathasdiag pathasdiag) {
        return repository.save(pathasdiag);
    }

    @Override
    public void delete(Integer pid, Integer diagid) {
        repository.deleteById(new PathasdiagPK(pid,diagid));
    }


}
