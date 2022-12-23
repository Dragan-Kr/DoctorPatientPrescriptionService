package com.example.demo.repositories;

import com.example.demo.entities.Pathasdiag;
import com.example.demo.entities.PathasdiagPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatHasDiagRepository extends JpaRepository<Pathasdiag, PathasdiagPK> {
}
