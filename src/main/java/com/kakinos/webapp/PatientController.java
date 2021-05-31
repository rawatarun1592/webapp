package com.kakinos.webapp;

import java.util.List;
import java.util.Optional;

import com.kakinos.webapp.model.Patient;
import com.kakinos.webapp.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(path="/create_new_patient",method=RequestMethod.POST)
    public ModelAndView create_new_patient(@ModelAttribute("patient") Patient patient, 
        @RequestParam String firstName,
        @RequestParam String lastName,
        @RequestParam Integer age,
        @RequestParam String gender,
        @RequestParam String city,
        @RequestParam Integer pincode) {
        patientRepository.save(new Patient(patient.getFirstName(), patient.getLastName(), patient.getAge(), patient.getGender(), patient.getCity(), patient.getPincode()));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("submitmessage");
        modelAndView.addObject("firstName", firstName);
        modelAndView.addObject("lastName", lastName);
        modelAndView.addObject("age", age);
        modelAndView.addObject("gender", gender);
        modelAndView.addObject("city", city);
        modelAndView.addObject("pincode", pincode);

        return modelAndView;
    }

    @RequestMapping(path="/search_patient_form",method=RequestMethod.GET)
    public ModelAndView search_patient_form() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search_patient_form");

        return modelAndView;
    }

    // @RequestMapping(path="/search_patient")
    // public ModelAndView search_patient(@RequestParam String name) 
    // {
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("search_result");
    //     modelAndView.addObject("patient", patientRepository.findByFirstName(name));
    //     System.out.println(patientRepository.findAll());
    //     return modelAndView;
    // }

    // @RequestMapping("/search_patient")
    // public List<Patient> getByFirstName(@PathVariable String firstName) {
    //     List<Patient> patients = this.patientRepository.findByFirstName(firstName);
    //     System.out.println("********************************");
    //     return patients;
    // }

    @RequestMapping(path="/search_patient",method=RequestMethod.GET)
    public ModelAndView search_patient(@RequestParam String firstname) 
    {
       // patientRepository.findByName(name);
       // patientRepository.findByFirstName(firstname);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search_result");
        modelAndView.addObject("patient", patientRepository.findByFirstName(firstname));

        return modelAndView;
    }
    // @RequestMapping(path="/search_patient",method=RequestMethod.GET)
    // public List<Patient> search_patient(@RequestParam String firstName) 
    // {
    //     return patientRepository.findByFirstName(firstName);
    //    // patientRepository.findByName(name);
    //    // return patientRepository.findById(id);
    //     //return patient.get();
    // }
}
