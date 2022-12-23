package com.example.demo.services;

import com.example.demo.dtos.DocGivesDiagDto;
import com.example.demo.entities.Docgivesdiag;

import java.util.Collection;

public interface DocGivesDiagService {
    DocGivesDiagDto getDocGivesDiagById(Integer docid, Integer warid, Integer diagid);

    Collection<Docgivesdiag> findAllObjects();

    DocGivesDiagDto insert(DocGivesDiagDto docGivesDiag);

    DocGivesDiagDto update(DocGivesDiagDto docGivesDiagDto, Integer docid, Integer warid, Integer diagid);

    void delete(Integer docid, Integer warid, Integer diagid);
}
