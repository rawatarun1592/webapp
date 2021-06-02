package com.kakinos.webapp;

import java.io.IOException;
import java.util.Base64;

import com.kakinos.webapp.model.Patient;
import com.kakinos.webapp.model.Photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
    // return "Profile Uploaded";

    }

    @GetMapping("/photos/{id}")
    public ModelAndView getPhoto(@PathVariable String id, Model model, @ModelAttribute("patient") Patient patient) 
    // @RequestParam String firstName,
    // @RequestParam String lastName,
    // @RequestParam Integer age,
    // @RequestParam String gender,
    // @RequestParam String city,
    // @RequestParam Integer pincode) 
    {
    Photo photo = photoService.getPhoto(id);
    model.addAttribute("title", photo.getTitle());
    model.addAttribute("image", 
    Base64.getEncoder().encodeToString(photo.getImage().getData()));
   // return "photo";
   ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("submitmessage");
   modelAndView.addObject("firstName", patient.getFirstName());
        modelAndView.addObject("lastName", patient.getLastName());
        modelAndView.addObject("age", patient.getAge());
        modelAndView.addObject("gender", patient.getGender());
        modelAndView.addObject("city", patient.getCity());
        modelAndView.addObject("pincode", patient.getPincode());
    
        return modelAndView;
}
}
