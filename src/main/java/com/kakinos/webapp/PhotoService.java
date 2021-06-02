package com.kakinos.webapp;

import java.io.IOException;

import com.kakinos.webapp.model.Patient;
import com.kakinos.webapp.model.Photo;
import com.kakinos.webapp.repository.PatientRepository;
import com.kakinos.webapp.repository.PhotoRepository;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepo;

    @Autowired
    private PatientRepository patientRepository;

    public void addPhoto(String title, MultipartFile file, Patient patient) throws IOException {
        Photo photo = new Photo(title);
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        System.out.println("before inserting photo************");
        patient.setPhoto(photo);
        patientRepository.save(patient);
        System.out.println("after inserting photo************");
    }

    public Photo getPhoto(String id) {
        Photo photo = new Photo();
        photo = photoRepo.findById(id).get();
        return photo;
    }
}
