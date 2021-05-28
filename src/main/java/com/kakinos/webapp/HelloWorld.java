package com.kakinos.webapp;

import com.kakinos.webapp.model.Patient;
import com.kakinos.webapp.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class HelloWorld {

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

    @RequestMapping("/create_new_patient")
    public ModelAndView create_new_patient() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("submitmessage");

        return modelAndView;
    }

    @PostMapping("/patient")
    public ResponseEntity<Patient> createTutorial(@RequestBody Patient patient) {
    try {
      System.out.println("hello");
    //  Patient _patient = PatientRepository.save(new Patient(patient.getFirstName(), patient.getAge()));
      Patient _patient = patientRepository.save(new Patient("Sunny", "IIIT", 25, "male", "Allahabad", 123456));
        return new ResponseEntity<>(_patient, HttpStatus.CREATED);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
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
