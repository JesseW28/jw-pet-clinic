package com.jw.jwpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vets")
public class VetController {

    @GetMapping({"list", "all"})
    public String list() {
        return "vets/index";
    }
}
