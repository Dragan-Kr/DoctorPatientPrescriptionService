package com.example.demo.controllers;

import com.example.demo.dtos.DocGivesDiagDto;
import com.example.demo.dtos.PatHasDiagDto;
import com.example.demo.entities.Pathasdiag;
import com.example.demo.services.PatHasDiagSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8085")
@RestController
public class PatHasDiagController {

    @Autowired
    private PatHasDiagSerice patHasDiagSerice;

    @GetMapping("patHasDiag")
    public Collection<Pathasdiag> getAllDocGivesDiag(){
        return patHasDiagSerice.findAllObjects();
    }

    @GetMapping("patHasDiag/{pid}/{diagid}")
    public  ResponseEntity<PatHasDiagDto> getPatHasDiagById(@PathVariable("pid") Integer pid,@PathVariable("diagid") Integer diagid){
      return ResponseEntity.ok(patHasDiagSerice.getPatHasDiagById(pid,diagid));
    }


    @PostMapping("patHasDiag")
    public ResponseEntity<PatHasDiagDto> insertPatHasDiag(@RequestBody PatHasDiagDto patHasDiagDto){
          return ResponseEntity.ok(patHasDiagSerice.insert(patHasDiagDto));
    }

    @PostMapping("patHasDiagnosis")
     public ResponseEntity<Pathasdiag> insertPatHasDiagnosis(@RequestBody Pathasdiag pathasdiag){
        return ResponseEntity.ok(patHasDiagSerice.create(pathasdiag));
    }



    @PutMapping("patHasDiag/{pid}/{diagid}")
    public ResponseEntity<PatHasDiagDto> updatePatHasDiag(@RequestBody PatHasDiagDto patHasDiagDto,@PathVariable("pid") Integer pid,@PathVariable("diagid") Integer diagid){
        return ResponseEntity.ok(patHasDiagSerice.update(patHasDiagDto,pid,diagid));
    }


    @DeleteMapping("patHasDiag/{pid}/{diagid}")
    public ResponseEntity<PatHasDiagDto> deletePatHasDiag(@PathVariable("pid") Integer pid,@PathVariable("diagid") Integer diagid){
        patHasDiagSerice.delete(pid,diagid);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}

