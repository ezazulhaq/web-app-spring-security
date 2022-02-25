package com.haa.webappspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String welcome(Model theModel) {
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeaders(Model theModel) {
        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystems(Model theModel) {
        return "systems";
    }
}
