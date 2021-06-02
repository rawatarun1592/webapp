package com.kakinos.webapp;

import java.util.Optional;

import com.kakinos.webapp.model.Patient;
import com.kakinos.webapp.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(path="/search_patient",method=RequestMethod.GET)
    public ModelAndView search_patient(@RequestParam String firstName) 
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search_result");
        modelAndView.addObject("patients", patientRepository.findByFirstName(firstName));

        return modelAndView;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPatientPage(@PathVariable(name = "id") String id) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("edit_patient");
    // Patient patient = patientRepository.get(id);
    modelAndView.addObject("patient", patientRepository.findById(id));
    modelAndView.addObject("id", id);
    return modelAndView;
    }

    @RequestMapping(path = "/update/{id}",method=RequestMethod.POST)
    public ModelAndView updatePatient(@ModelAttribute("patient") Patient patient, @PathVariable String id)
        {
        Optional<Patient> patientData = patientRepository.findById(id);
        Patient _patient = patientData.get();
        _patient.setFirstName(patient.getFirstName());
        _patient.setLastName(patient.getLastName());
        _patient.setAge(patient.getAge());
        _patient.setGender(patient.getGender());
        _patient.setCity(patient.getCity());
        _patient.setPincode(patient.getPincode());
        patientRepository.save(_patient);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("submitmessage");
        modelAndView.addObject("firstName", _patient.getFirstName());
        modelAndView.addObject("lastName", _patient.getLastName());
        modelAndView.addObject("age", _patient.getAge());
        modelAndView.addObject("gender", _patient.getGender());
        modelAndView.addObject("city", _patient.getCity());
        modelAndView.addObject("pincode", _patient.getPincode());
    
        return modelAndView;
        
    }
    
    @RequestMapping("/delete/{id}")
    public String deletePatient(@PathVariable(name = "id") String id) {
    patientRepository.deleteById(id);
    return "redirect:/";       
    }

    @RequestMapping(path="/upload_photo/{id}", method = RequestMethod.GET)
    public ModelAndView upload_photo(@PathVariable(name = "id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("uploadPhoto");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    // @RequestMapping(path = "/updated_profile/{id}",method=RequestMethod.GET)
    // public ModelAndView updated_profile(@ModelAttribute("patient") Patient patient, @PathVariable String id)
    //     {
    //     Optional<Patient> patientData = patientRepository.findById(id);
    //     Patient _patient = patientData.get();
    //     System.out.println(patientData.get().getFirstName());
    //     _patient.setFirstName(patient.getFirstName());
    //     _patient.setLastName(patient.getLastName());
    //     _patient.setAge(patient.getAge());
    //     _patient.setGender(patient.getGender());
    //     _patient.setCity(patient.getCity());
    //     _patient.setPincode(patient.getPincode());
    //     _patient.setPhoto(patient.getPhoto());
    //     patientRepository.save(_patient);
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("submitmessage");
    //     modelAndView.addObject("firstName", _patient.getFirstName());
    //     modelAndView.addObject("lastName", _patient.getLastName());
    //     modelAndView.addObject("age", _patient.getAge());
    //     modelAndView.addObject("gender", _patient.getGender());
    //     modelAndView.addObject("city", _patient.getCity());
    //     modelAndView.addObject("pincode", _patient.getPincode());
    //     modelAndView.addObject("photo", _patient.getPhoto());
    
    //     return modelAndView;
        
    // }  
}
