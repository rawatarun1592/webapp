package com.kakinos.webapp;

import java.io.IOException;
import java.util.Base64;

import com.kakinos.webapp.model.Photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PhotoController {
    
    @Autowired
    private PhotoService photoService;

    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("title") String title, 
    @RequestParam("image") MultipartFile image, Model model) 
    throws IOException {
    String id = photoService.addPhoto(title, image);
    System.out.println("insert add photo" + id);
    return "redirect:/photos/" + id;
    }

    @GetMapping("/photos/{id}")
    public String getPhoto(@PathVariable String id, Model model) {
    Photo photo = photoService.getPhoto(id);
    model.addAttribute("title", photo.getTitle());
    model.addAttribute("image", 
    Base64.getEncoder().encodeToString(photo.getImage().getData()));
    return "photo";
}
}
