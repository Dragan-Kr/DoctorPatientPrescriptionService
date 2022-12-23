package com.example.demo.repositories;

import com.example.demo.entities.Docgivesdiag;
import com.example.demo.entities.DocgivesdiagPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocGivesDiagRepository extends JpaRepository<Docgivesdiag, DocgivesdiagPK> {
}
