package com.kakinos.webapp.repository;


import java.util.List;
import java.util.Optional;

import com.kakinos.webapp.model.Patient;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;

public interface PatientRepository extends MongoRepository<Patient, String> {
  Page<Patient> findByFirstName(String firstName, Pageable pageable);
  Optional<Patient> findById(String id);
  List<Patient> findAll();

   Patient findByFirstName(String firstName);
}

