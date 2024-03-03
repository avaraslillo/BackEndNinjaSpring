package com.udemy.backendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.service.Example5Service;



@Controller
@RequestMapping("/ejercicio")

public class Example5Controller {

    public static final String EXAMPLE_VIEW="example3";

    @Autowired
    @Qualifier("example5Service")
    private Example5Service example5Service;


    @GetMapping("/BuffySummers")
    public RedirectView BuffySummers(){
        return new RedirectView("/ejercicio/WillowRosenberg");
    }

    @GetMapping("/WillowRosenberg")
    public ModelAndView WillowRosenberg(){
        example5Service.MensajeLog();
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("mensaje","Soy la bruja Willow Rosenberg");
        System.out.println("Soy la bruja Willow Rosenberg");
        return mav;
    }



    
}
