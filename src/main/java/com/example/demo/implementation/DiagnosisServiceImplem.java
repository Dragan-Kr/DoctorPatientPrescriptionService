package com.example.demo.implementation;

import com.example.demo.dtos.DiagnosisDto;
import com.example.demo.entities.Diagnosis;
import com.example.demo.repositories.DiagnosisRepository;
import com.example.demo.services.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DiagnosisServiceImplem implements DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;
    private String baseUrl="http://localhost:8084/diagnosis";

    @Override
    public Diagnosis getDiagnosisById(Integer diagid) {
        RestTemplate diagRest = new RestTemplate();
        DiagnosisDto diagnosis = diagRest.getForObject(baseUrl + "/" + diagid,DiagnosisDto.class);
        Diagnosis mappedDiagnosis = new Diagnosis();
        mappedDiagnosis.setDiagDate(diagnosis.getDiagDate());
        mappedDiagnosis.setName(diagnosis.getName());
        mappedDiagnosis.setObservation(diagnosis.getObservation());
        mappedDiagnosis.setId(diagnosis.getId());
        return  mappedDiagnosis;
    }



}
