package com.jw.jwpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping({"/oups"})
    public String oupsHandler() {

        return "notimplemented";
    }
}
