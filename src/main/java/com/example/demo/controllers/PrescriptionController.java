package com.example.demo.controllers;

import com.example.demo.dtos.PrescriptionDto;
import com.example.demo.entities.Prescription;
import com.example.demo.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin(origins = "http://localhost:8085")
@RestController
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("prescription")
    public Collection<Prescription> getAllPrescriptions(){
        return prescriptionService.findAllObjects();
    }

    @GetMapping("prescription/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(prescriptionService.getPrescriptionById(id));
    }

    @PostMapping("prescription")
    public ResponseEntity<PrescriptionDto> createPrescription(@RequestBody PrescriptionDto prescriptionDto){
        return ResponseEntity.ok(prescriptionService.createPrescription(prescriptionDto));
    }

    @PutMapping("prescription/{id}")
    public ResponseEntity<PrescriptionDto> updatePrescription(@RequestBody PrescriptionDto prescriptionDto,@PathVariable("id") Integer id){
        return ResponseEntity.ok(prescriptionService.update(prescriptionDto,id));
    }


    @DeleteMapping("prescription/{id}")
    public ResponseEntity<PrescriptionDto> deletePrescritpion(@PathVariable("id") Integer id){
       prescriptionService.deleteById(id);
       return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
