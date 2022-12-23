package com.example.demo.implementation;

import com.example.demo.dtos.DocGivesDiagDto;
import com.example.demo.entities.Docgivesdiag;
import com.example.demo.entities.DocgivesdiagPK;
import com.example.demo.entities.DoctorPK;
import com.example.demo.repositories.DocGivesDiagRepository;
import com.example.demo.services.DiagnosisService;
import com.example.demo.services.DocGivesDiagService;
import com.example.demo.services.DoctorService;
import com.example.demo.services.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Service
public class DocGivesDiagServiceImplem implements DocGivesDiagService {

    @Autowired
    private DocGivesDiagRepository repository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DiagnosisService diagnosisService;


    @Autowired
    private WardService wardService;

    RestTemplate restTemplate = new RestTemplate();
    String restDiagnosisUri = "http://localhost:8084/diagnosis";
    String restWardUri = "http://localhost:8080/ward";

    @Override
    public DocGivesDiagDto getDocGivesDiagById(Integer docid, Integer warid, Integer diagid) {

        Docgivesdiag foundDocGivesDiag = repository.findById(new DocgivesdiagPK(docid,warid,diagid)).get();

        foundDocGivesDiag.setDocid((doctorService.getById(new DoctorPK(docid,warid))).getId());
        foundDocGivesDiag.setWarid((wardService.getWardById(foundDocGivesDiag.getWarid())).getId());
        foundDocGivesDiag.setDiagid((diagnosisService.getDiagnosisById(foundDocGivesDiag.getDiagid())).getId());
        DocGivesDiagDto mapped = new DocGivesDiagDto(foundDocGivesDiag.getDocid(),foundDocGivesDiag.getDiagid(),foundDocGivesDiag.getWarid());
        return  mapped;
    }

    @Override
    public Collection<Docgivesdiag> findAllObjects() {
        return repository.findAll();
    }

    @Override
    public DocGivesDiagDto insert(DocGivesDiagDto docGivesDiag) {
        Docgivesdiag newDocgivesdiag = new Docgivesdiag();

        newDocgivesdiag.setDocid(docGivesDiag.getDocid());
        newDocgivesdiag.setWarid(docGivesDiag.getWarid());
        newDocgivesdiag.setDiagid(docGivesDiag.getDiagid());

        newDocgivesdiag = repository.save(newDocgivesdiag);
        DocGivesDiagDto mapped = new DocGivesDiagDto(newDocgivesdiag.getDocid(),newDocgivesdiag.getWarid(),newDocgivesdiag.getDiagid());
        return  mapped;
    }

    @Override
    public DocGivesDiagDto update(DocGivesDiagDto docGivesDiag, Integer docid, Integer warid, Integer diagid) {
         Docgivesdiag updated = repository.findById(new DocgivesdiagPK(docid,warid,diagid)).map(oldDocGivesDiag ->{
             oldDocGivesDiag.setDocid(docGivesDiag.getDocid());
             oldDocGivesDiag.setWarid(docGivesDiag.getWarid());

//             oldDocGivesDiag.setDiagid(docGivesDiag.getDiagid());\ oldDocGivesDiag.setWarid(docGivesDiag.getWarid());
             oldDocGivesDiag.setDiagid(diagnosisService.getDiagnosisById(docGivesDiag.getDiagid()).getId());
             return  repository.save(oldDocGivesDiag);
                 }


         ).get();
//         updated.setDoctor(doctorService.getDoctorById(updated.getDocid(),updated.getWarid()));
        DocGivesDiagDto mapped = new DocGivesDiagDto(updated.getDocid(), updated.getDiagid(), updated.getWarid());
        return mapped;
    }


//    @Override
//    public StaffDTO update(StaffModificationDTO staff, Integer id, Integer wardid) {
//        Staff updatedStaff = staffRepository.findById(new StaffPK(id,wardid)).map(oldStaff ->{
//            oldStaff.setEducation(staff.getEducation());
//            oldStaff.setForen_languages(staff.getForen_languages());
//            oldStaff.setJoined(staff.getJoined());
//            return  staffRepository.save(oldStaff);
//
//        }).get();
////        updatedStaff.setPerson(personService.getPersonById(updatedStaff.getId()));
////        updatedStaff.setWard(wardService.getWardById(updatedStaff.getWardid()));
//        StaffDTO mappedStaff = new StaffDTO(updatedStaff.getId(),updatedStaff.getWardid(),updatedStaff.getEducation(),updatedStaff.getForen_languages(),updatedStaff.getJoined());
//        return  mappedStaff;
//    }

    @Override
    public void delete(Integer docid, Integer warid, Integer diagid) {
        repository.deleteById(new DocgivesdiagPK(docid,warid,diagid));
    }



}
