package com.itgenius.springbootlayout.controller;

import com.itgenius.springbootlayout.model.Student;
import com.itgenius.springbootlayout.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BackendController {

    // เรียกใช้งาน Service / List / Add / Update / Delete
    @Autowired
    private StudentService stdService;

    // Dashboard
    @GetMapping(value = "/backend/dashboard")
    public String dashboard(){
        return "backend/dashboard";
    }

    // List Student
    @GetMapping(value = "/backend/student")
    public String student(){
        return "backend/student";
    }

    // New Student
    @GetMapping(value = "/backend/newstudent")
    public String newstudent(ModelMap model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "backend/newstudent";
    }

    // Add Student
    @PostMapping("/backend/savestudent")
    public String saveStudent(
        @Validated Student student,
        BindingResult result,
        RedirectAttributes redirectAttributes){
            if(result.hasErrors()){
                return "backend/newstudent";
            }else{
                // บันทึกข้อมูล
                stdService.save(student);
                return "redirect:/backend/student";
            }
    }

}
