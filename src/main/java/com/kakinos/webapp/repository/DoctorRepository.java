package com.kakinos.webapp.repository;


import java.util.List;

import com.kakinos.webapp.model.Doctor;
//import com.kakinos.webapp.model.Patient;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
  // List<Doctor> findBySpecialization(String specialization);
  @Query(value = "{$and:[{specialization:{$regex:?0,$options:'i'}},{city:{$regex:?1,$options:'i'}}]}")
    List<Doctor> getBySpecializationAndCity(String specialization, String city);
   // List<Doctor> getByCity(String city);
  
}

