package com.kakinos.webapp.repository;


//import java.util.List;

import com.kakinos.webapp.model.Patient;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
 // List<Patient> findByFirstNameContaining(String first_name);
//   List<Tutorial> findByPublished(boolean published);
}