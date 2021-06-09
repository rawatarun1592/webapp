package com.kakinos.webapp.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import com.kakinos.webapp.model.Doctor;
//import com.kakinos.webapp.model.Patient;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

    
    List<Doctor> findBySpecializationAndCity(String specialization, String city);
    List<Doctor> findAll();
    Page<Doctor> findByFirstName(String firstName, Pageable pageable);
    Optional<Doctor> findById(String id);
    Doctor findByFirstName(String firstName);
  
}

