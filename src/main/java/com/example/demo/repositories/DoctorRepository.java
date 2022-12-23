package com.example.demo.repositories;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.DoctorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, DoctorPK> {

}
