package com.example.demo.services;

import com.example.demo.dtos.PatHasDiagDto;
import com.example.demo.entities.Pathasdiag;

import java.util.Collection;

public interface PatHasDiagSerice {
    Collection<Pathasdiag> findAllObjects();

    PatHasDiagDto getPatHasDiagById(Integer pid, Integer diagid);

    PatHasDiagDto insert(PatHasDiagDto patHasDiagDto);

    PatHasDiagDto update(PatHasDiagDto patHasDiagDto, Integer pid, Integer diagid);

    Pathasdiag create(Pathasdiag pathasdiag);

    void delete(Integer pid, Integer diagid);
}
