package com.kakinos.webapp;

import com.kakinos.webapp.model.Patient;
import com.kakinos.webapp.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @RequestMapping("/new_patient")
    public ModelAndView new_patient() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new_patient");

        return modelAndView;
    }

    // @PostMapping("/patient")
    // public ResponseEntity<Patient> createPatient() {
    // try {
    //   System.out.println("hello");
    //  // Patient _patient = patientRepository.save(new Patient(patient.getFirstName(), patient.getLastName(), patient.getAge(), patient.getGender(), patient.getCity(), patient.getPinCode()));
    //   Patient _patient = patientRepository.save(new Patient("Sunny", "IIIT", 25, "male", "Allahabad", 123456));
    //     return new ResponseEntity<>(_patient, HttpStatus.CREATED);
    //   } catch (Exception e) {
    //     return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //   }
    // }

    // @PostMapping("/patient")
    // public ModelAndView createPatient(@RequestBody  Patient patient) {
    
    //   System.out.println("hello");
    //   patientRepository.save(new Patient(patient.getFirstName(), patient.getLastName(), patient.getAge(), patient.getGender(), patient.getCity(), patient.getPinCode()));
    //   ModelAndView modelAndView = new ModelAndView();
    //   System.out.println("hello hello");
    //   modelAndView.setViewName("submitmessage");

    //   return modelAndView;
    //  // return "submitmessage";
    // }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("patient") Patient patient) {
      System.out.println("hello");
    patientRepository.save(patient);
     
    return "submitmessage";
}

    @RequestMapping("/create_new_patient")
    public ModelAndView create_new_patient() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("submitmessage");

        return modelAndView;
    }

    @RequestMapping("/search_patient_form")
    public ModelAndView search_patient_form() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search_patient_form");

        return modelAndView;
    }

    @RequestMapping("/search_patient")
    public ModelAndView search_patient() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search_result");

        return modelAndView;
    }
}
