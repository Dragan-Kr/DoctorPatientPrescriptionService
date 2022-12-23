package com.example.demo.repositories;

import com.example.demo.entities.Nurse;
import com.example.demo.entities.NursePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, NursePK> {
}
