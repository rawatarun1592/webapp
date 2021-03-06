package com.kakinos.webapp.repository;


import java.util.List;
import java.util.Optional;

import com.kakinos.webapp.model.Patient;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
  List<Patient> findByFirstName(String firstName);
  Optional<Patient> findById(String id);
  List<Patient> findAll();
  
}

