package com.itgenius.springbootlayout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    // Home
    @GetMapping(value = "/")
    public String index(){
        return "frontend/index";
    }

    // About
    @GetMapping(value = "/about")
    public String about(){
        return "frontend/about";
    }

    // Service
    @GetMapping(value = "/service")
    public String service(){
        return "frontend/service";
    }

    // Contact
    @GetMapping(value = "/contact")
    public String contact(){
        return "frontend/contact";
    }

    // Register
    @GetMapping(value = "/register")
    public String register(){
        return "frontend/register";
    }

    // Login
    @GetMapping(value = "/login")
    public String login(){
        return "frontend/login";
    }

}
