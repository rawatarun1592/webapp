package com.kakinos.webapp.repository;

import com.kakinos.webapp.model.Photo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> { }

