package com.kakinos.webapp;

import java.io.IOException;
import com.kakinos.webapp.model.Photo;
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

    public String addPhoto(String title, MultipartFile file) throws IOException { 
        Photo photo = new Photo(title); 
        photo.setImage(
          new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
          System.out.println("before inserting photo************");
        photo = photoRepo.insert(photo); 
        System.out.println("after inserting photo************");
        return photo.getId(); 
    }

    public Photo getPhoto(String id) { 
        Photo photo = new Photo();
        photo = photoRepo.findById(id).get(); 
        System.out.println("photo" + photo.getImage());
        return photo;
    }
}
