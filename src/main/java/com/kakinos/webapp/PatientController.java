package com.kakinos.webapp;

import com.kakinos.webapp.model.Patient;
import com.kakinos.webapp.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    // @RequestMapping(value = "/patient", method = RequestMethod.POST)
    // public String savePatient(@ModelAttribute("patient") Patient patient) {
    //   System.out.println("*************************************************");
    //     //patientRepository.save(patient);
    //     patientRepository.save(new Patient(patient.getFirst_name(), patient.getLast_name(), patient.getAge(), patient.getGender(), patient.getCity(), patient.getPinCode()));

    //     return "submitmessage";
    // }

    @RequestMapping(path="/create_new_patient",method=RequestMethod.POST)
    public ModelAndView create_new_patient(@ModelAttribute("patient") Patient patient, 
        @RequestParam String first_name,
        @RequestParam String last_name,
        @RequestParam Integer age,
        @RequestParam String gender,
        @RequestParam String city,
        @RequestParam Integer pincode) {
        patientRepository.save(new Patient(patient.getFirst_name(), patient.getLast_name(), patient.getAge(), patient.getGender(), patient.getCity(), patient.getPinCode()));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("submitmessage");
        modelAndView.addObject("first_name", first_name);
        modelAndView.addObject("last_name", last_name);
        modelAndView.addObject("age", age);
        modelAndView.addObject("gender", gender);
        modelAndView.addObject("city", city);
        modelAndView.addObject("pincode", pincode);

        return modelAndView;
    }

    @RequestMapping("/search_patient_form")
    public ModelAndView search_patient_form() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search_patient_form");

        return modelAndView;
    }

    @RequestMapping(path="/search_patient",method=RequestMethod.POST)
    public ModelAndView search_patient(@RequestParam String name) 
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search_result");
        modelAndView.addObject("name", name);

        return modelAndView;
    }
}
