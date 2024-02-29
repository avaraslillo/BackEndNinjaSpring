package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.model.Person;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

    private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
    public static final String FORM_VIEW = "form";
    public static final String RESULT_VIEW = "result";


    /*@GetMapping("/")
    public String redirect(){
        return "redirect:/example3/showform";
    }*/

    @GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("/example3/showform");
    }

    @GetMapping("/showform")
    public String showForm(Model model){
        LOGGER.info("INFO_TRACE");
        LOGGER.warn("WARNING_TRACE");
        LOGGER.error("ERROR_TRACE");
        LOGGER.debug("DEBUG_TRACE");
        model.addAttribute("person", new Person());
        return FORM_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult){
        LOGGER.info("METHOD: 'addPerson' -- PARAMS: '"+person+"'");
        ModelAndView mav = new ModelAndView();
        
        LOGGER.info("TEMPLATE: '"+RESULT_VIEW+"' -- DATA '"+person+"'");

        if(bindingResult.hasErrors()){
            mav.setViewName(FORM_VIEW);
        }else{
            mav.setViewName(RESULT_VIEW);
            mav.addObject("person", person);
        }
        

        return mav;
    }
}
