package com.jw.jwpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("owners")
public class OwnerController {

    @GetMapping({"list", "all"})
    public String list() {
        return "owners/index";
    }
}
