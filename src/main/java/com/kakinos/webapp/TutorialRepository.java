package com.kakinos.webapp;

// package com.bezkoder.spring.data.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

// import com.bezkoder.spring.data.mongodb.model.Tutorial;

public interface TutorialRepository extends MongoRepository<DataModel, String> {
  List<DataModel> findByTitleContaining(String title);
  List<DataModel> findByPublished(boolean published);
}
