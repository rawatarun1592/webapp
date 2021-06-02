package com.kakinos.webapp;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import com.kakinos.webapp.model.Patient;
import com.kakinos.webapp.model.Photo;
import com.kakinos.webapp.repository.PatientRepository;
import com.kakinos.webapp.repository.PhotoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhotoController {
    
    @Autowired
    private PhotoService photoService;
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/photos/add/{id}")
    public String addPhoto(@PathVariable String id, @RequestParam("title") String title, 
    @RequestParam("image") MultipartFile image, Model model) 
    throws IOException {
    Optional<Patient> patient = patientRepository.findById(id);
    photoService.addPhoto(title, image, patient.get());
    // System.out.println("insert add photo" + id);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("id", id);
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
