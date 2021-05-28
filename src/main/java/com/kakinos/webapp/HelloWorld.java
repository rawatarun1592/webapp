package com.kakinos.webapp;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class HelloWorld {
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
