package com.kakinos.webapp;

import java.util.Optional;

import com.kakinos.webapp.model.Doctor;
import com.kakinos.webapp.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


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
        @RequestParam String phoneNumber,
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
    @RequestMapping(path="/search_doctor_form",method=RequestMethod.GET)
    public ModelAndView search_doctor_form() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search_doctor_form");

        return modelAndView;
    }
    @RequestMapping(path="/search_doctor",method=RequestMethod.GET)
    public ModelAndView search_doctor(@RequestParam String specialization, @RequestParam String city) 
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search_doctor_result");
        modelAndView.addObject("doctors", doctorRepository.findBySpecializationAndCity(specialization, city));
        //modelAndView.addObject("doctors", doctorRepository.getByCity(city));

        return modelAndView;
    }

    @RequestMapping(path="/view_all_doctor",method=RequestMethod.GET)
    public ModelAndView view_all_doctor() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_all_doctor");
        modelAndView.addObject("doctors", doctorRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/edit1/{id}")
    public ModelAndView showEditDoctorPage(@PathVariable(name = "id") String id) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("edit_doctor");
    // Patient patient = patientRepository.get(id);
    modelAndView.addObject("doctor", doctorRepository.findById(id));
    modelAndView.addObject("id", id);
    return modelAndView;
    }
    @RequestMapping(value ="/update1/{id}",method=RequestMethod.POST)
    public ModelAndView updatePatient(@ModelAttribute("doctor") Doctor doctor, @PathVariable String id)
        {
        Optional<Doctor> doctorData = doctorRepository.findById(id);
        Doctor _doctor = doctorData.get();
        _doctor.setFirstName(doctor.getFirstName());
        _doctor.setLastName(doctor.getLastName());
        _doctor.setSpecialization(doctor.getSpecialization());
        _doctor.setPhoneNumber(doctor.getPhoneNumber());
        _doctor.setAddress(doctor.getAddress());
        _doctor.setCity(doctor.getCity());
        _doctor.setPincode(doctor.getPincode());
        doctorRepository.save(_doctor);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("submitdoctor");
        modelAndView.addObject("firstName", _doctor.getFirstName());
        modelAndView.addObject("lastName", _doctor.getLastName());
        modelAndView.addObject("specialization", _doctor.getSpecialization());
        modelAndView.addObject("phoneNumber", _doctor.getPhoneNumber());
        modelAndView.addObject("address", _doctor.getAddress());
        modelAndView.addObject("city", _doctor.getCity());
        modelAndView.addObject("pincode", _doctor.getPincode());
    
        return modelAndView;
        
    }
    @RequestMapping(value = "/delete1/{id}")
    public String deleteDoctor(@PathVariable(name = "id") String id) {
    doctorRepository.deleteById(id);
    return "redirect:/";       
    }

    @RequestMapping(path = "/view_all_doctor/{page}", method = RequestMethod.GET)
    public ModelAndView view_all_doctor(@PathVariable("page") Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        ModelAndView modelAndView = new ModelAndView();
        Page<Doctor> doctors = doctorRepository.findAll(pageable);
        modelAndView.setViewName("view_all_doctor");
        modelAndView.addObject("doctors", doctors.getContent());
        modelAndView.addObject("currentPage", doctors.getNumber());
        modelAndView.addObject("totalPage", doctors.getTotalPages());
        

        return modelAndView;
    }
    
}
