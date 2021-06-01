package com.kakinos.webapp.repository;


import java.util.List;

import com.kakinos.webapp.model.Doctor;
//import com.kakinos.webapp.model.Patient;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
  List<Doctor> findByFirstName(String firstName);
  
}

