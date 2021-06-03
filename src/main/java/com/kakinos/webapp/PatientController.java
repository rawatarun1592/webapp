package com.kakinos.webapp;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import com.kakinos.webapp.model.Patient;
import com.kakinos.webapp.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
        patientRepository.save(new Patient(patient.getFirstName(), patient.getLastName(), patient.getAge(), patient.getGender(), patient.getCity(), patient.getPincode(), patient.getPhotos()));
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

    // @RequestMapping(path="/search_patient",method=RequestMethod.GET)
    // public List<Patient> search_patient(@RequestParam String firstName) 
    // {
    //     return patientRepository.findByFirstName(firstName);
    //    // return patientRepository.findById(id);
    //     //return patient.get();
    // }

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
    
    @RequestMapping(path="/upload_pic/{id}",method = RequestMethod.GET)
    public ModelAndView showupload_pic_page(@PathVariable(name = "id") String id) {
   
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("upload_pic");
    modelAndView.addObject("patient", patientRepository.findById(id));
    System.out.println(id);
    modelAndView.addObject("id", id);
    System.out.println("upload pic");
    return modelAndView;
    }

    @RequestMapping(path="/photos/add/{id}",method=RequestMethod.POST)
    public String savePatientpic(Patient patient,
    @RequestParam("image") MultipartFile multipartFile,
    @PathVariable(name = "id") String id,
    Model model) 
    
    throws IOException {
    
    String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
    Optional<Patient> patientData = patientRepository.findById(id);
    Patient _patient = patientData.get();
    System.out.println(_patient.getFirstName());
        _patient.setPhotos(fileName);

        System.out.println(_patient.getFirstName()); 

        _patient.setFirstName(_patient.getFirstName());
        _patient.setLastName(_patient.getLastName());
        _patient.setAge(_patient.getAge());
        _patient.setGender(_patient.getGender());
        _patient.setCity(_patient.getCity());
        _patient.setPincode(_patient.getPincode());

        System.out.println(patient.getFirstName());

        Patient savedPatient = patientRepository.save(_patient);
 
        String uploadDir = "./patient-photos/" + savedPatient.getId();
        // System.out.println(patient1.get().getFirstName());
        System.out.println(savedPatient.getId());
        System.out.println(savedPatient.getLastName());
        System.out.println("add pic and ty");
      
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);}

        try(InputStream inputStream = multipartFile.getInputStream()){
        Path filePath = uploadPath.resolve(fileName);
        System.out.println(filePath.toFile().getAbsolutePath() );
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
        System.out.println("add pic and ty");
    
        return "ty_message";
    }
    
    @RequestMapping(path = "/view/{id}",method=RequestMethod.GET)
    public ModelAndView viewProfile(@ModelAttribute("patient") Patient patient, @PathVariable String id)
        {
        Optional<Patient> patientData = patientRepository.findById(id);
        // Patient _patient = patientData.get();
        // _patient.setFirstName(patient.getFirstName());
        // _patient.setLastName(patient.getLastName());
        // _patient.setAge(patient.getAge());
        // _patient.setGender(patient.getGender());
        // _patient.setCity(patient.getCity());
        // _patient.setPincode(patient.getPincode());
        //patientRepository.save(_patient);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view");
        modelAndView.addObject("PhotosImagePath",patientData.get().getPhotosImagePath());
        modelAndView.addObject("photos", patientData.get().getPhotosImagePath());
        modelAndView.addObject("firstName", patientData.get().getFirstName());
        modelAndView.addObject("lastName",patientData.get().getLastName());
        modelAndView.addObject("age", patientData.get().getAge());
        modelAndView.addObject("gender", patientData.get().getGender());
        modelAndView.addObject("city", patientData.get().getCity());
        modelAndView.addObject("pincode", patientData.get().getPincode());
         return modelAndView;
        
    }
}


