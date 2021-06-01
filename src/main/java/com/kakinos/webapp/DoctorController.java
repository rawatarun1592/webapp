package com.kakinos.webapp;

//import java.util.Optional;

import com.kakinos.webapp.model.Doctor;
//import com.kakinos.webapp.model.Patient;
import com.kakinos.webapp.repository.DoctorRepository;
//import com.kakinos.webapp.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
@EnableAutoConfiguration

public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

@RequestMapping("/new_doctor")
    public ModelAndView new_doctor() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new_doctor");

       return modelAndView;
    }

    @RequestMapping(path="/create_new_doctor",method=RequestMethod.POST)
    public ModelAndView create_new_doctor(@ModelAttribute("doctor") Doctor doctor,
        @RequestParam String firstName,
        @RequestParam String lastName,
        @RequestParam String specialization,
        @RequestParam Integer phoneNumber,
        @RequestParam String address,
        @RequestParam String city,
        @RequestParam Integer pincode) {
        doctorRepository.save(new Doctor(doctor.getFirstName(), doctor.getLastName(), doctor.getSpecialization(), doctor.getPhoneNumber(), doctor.getAddress(), doctor.getCity(), doctor.getPincode()));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("submitdoctor");
        modelAndView.addObject("firstName", firstName);
        modelAndView.addObject("lastName", lastName);
        modelAndView.addObject("specialization", specialization);
        modelAndView.addObject("phoneNumber", phoneNumber);
        modelAndView.addObject("address", address);
        modelAndView.addObject("city", city);
        modelAndView.addObject("pincode", pincode);

        return modelAndView;
    }
    
}
