package com.example.demo.controllers;

import com.example.demo.dtos.DocGivesDiagDto;
import com.example.demo.entities.Docgivesdiag;
import com.example.demo.services.DocGivesDiagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8085")
@RestController
public class DocGivesDiagController {


    @Autowired
    private DocGivesDiagService docGivesDiagService;



    @GetMapping("docGivesDiag")
    public Collection<Docgivesdiag> getAllDocGivesDiag(){
        return docGivesDiagService.findAllObjects();
    }


    @PostMapping("docGivesDiag")
    public ResponseEntity<DocGivesDiagDto> insertDocGivesDiag(@RequestBody DocGivesDiagDto docGivesDiag){
        return ResponseEntity.ok(docGivesDiagService.insert(docGivesDiag));
    }



    @GetMapping("docGivesDiag/{docid}/{warid}/{diagid}")
    public ResponseEntity<DocGivesDiagDto> getDocGivesDiagById(@PathVariable("docid") Integer docid,@PathVariable("warid") Integer warid, @PathVariable("diagid") Integer diagid){
        return ResponseEntity.ok(docGivesDiagService.getDocGivesDiagById(docid,warid,diagid));
    }

    @PutMapping("docGivesDiag/{docid}/{warid}/{diagid}")
    public ResponseEntity<DocGivesDiagDto> updateDocGivesDiag(@RequestBody DocGivesDiagDto docGivesDiagDto, @PathVariable("docid") Integer docid,@PathVariable("warid") Integer warid,@PathVariable("diagid") Integer diagid){
        return  ResponseEntity.ok(docGivesDiagService.update(docGivesDiagDto,docid,warid,diagid));
    }


    @DeleteMapping("docGivesDiag/{docid}/{warid}/{diagid}")
    public ResponseEntity<DocGivesDiagDto> deleteDocGivesDiag(@PathVariable("docid") Integer docid,@PathVariable("warid") Integer warid,@PathVariable("diagid") Integer diagid)
    {
        docGivesDiagService.delete(docid,warid,diagid);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
