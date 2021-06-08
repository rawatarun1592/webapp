package com.kakinos.webapp.repository;


import java.util.List;
import java.util.Optional;

import com.kakinos.webapp.model.Patient;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends MongoRepository<Patient, String> {
  List<Patient> findByFirstName(String firstName);
  Optional<Patient> findById(String id);
  List<Patient> findAll();

  public Page<Patient> findPatientsByPatient(@Param("patientId") int patientId, Pageable pageable);
  
  Patient getPatientByPatientName(String patientName);
Page<Patient> findPatientByPatient(String id, Pageable pageable);
}

