package com.kakinos.webapp;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import com.kakinos.webapp.model.Patient;
import com.kakinos.webapp.model.Photo;
import com.kakinos.webapp.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhotoController {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(path = "/photos/add/{id}" , method = RequestMethod.POST)
    public String addPhoto(@PathVariable(value = "id") String id, @RequestParam("title") String title,
            @RequestParam("image") MultipartFile image, Model model) throws IOException {
        Optional<Patient> patient = patientRepository.findById(id);
        photoService.addPhoto(title, image, patient.get());
        // ModelAndView modelAndView = new ModelAndView();
        // modelAndView.addObject("id", id);
        return "redirect:/photos/" + id;
    }

    @RequestMapping(path = "/photos/{id}")
    public String getPhoto(@PathVariable String id, Model model) {
        Optional<Patient> patient = patientRepository.findById(id);
        // Photo photo = photoService.getPhoto(id);
        model.addAttribute("title", patient.get().getPhoto().getTitle());
        model.addAttribute("image", Base64.getEncoder().encodeToString(patient.get().getPhoto().getImage().getData()));
        return "photo";
    }
}