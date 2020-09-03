package com.itgenius.springbootlayout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackendController {
    // Dashboard
    @GetMapping(value = "/backend/dashboard")
    public String dashboard(){
        return "backend/dashboard";
    }
}
