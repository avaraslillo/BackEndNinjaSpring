package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

    public static final String ERROR_404="500";
    @GetMapping("/simpleView")
    public String simpleView(){
        return ERROR_404;
    }
}
