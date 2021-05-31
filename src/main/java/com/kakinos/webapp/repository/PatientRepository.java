package com.kakinos.webapp.repository;


import java.util.List;

import com.kakinos.webapp.model.Patient;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;

public interface PatientRepository extends MongoRepository<Patient, String> {
  List<Patient> findByFirstName(String firstName);
//   List<Tutorial> findByPublished(boolean published);
    // @Query(value = "{firstName:{$regex:?0,$options:'i'}}")
    // List<Patient> findByFirstName(String firstName);

}