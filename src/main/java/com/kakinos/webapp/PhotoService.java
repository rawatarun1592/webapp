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
    private static PhotoRepository photoRepo;

    public static String addPhoto(String title, MultipartFile file) throws IOException { 
        Photo photo = new Photo(title, title, null); 
        photo.setImage(
          new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        photo = photoRepo.insert(photo); return photo.getId(); 
    }

    public static Photo getPhoto(String id) { 
        return photoRepo.findById(id).get(); 
    }
}
