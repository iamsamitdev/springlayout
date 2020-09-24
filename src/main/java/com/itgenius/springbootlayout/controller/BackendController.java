package com.itgenius.springbootlayout.controller;

import java.util.List;

import com.itgenius.springbootlayout.model.Student;
import com.itgenius.springbootlayout.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
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
    public ModelAndView student(){
        List<Student> list = stdService.findAll();
        return new ModelAndView("backend/student","list",list);
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

    // Load Edit Student Form
    @GetMapping(value = "/backend/editstudent/{id}")
    public String edit(@PathVariable int id,ModelMap model){
        Student student = stdService.getOne(id);
        model.addAttribute("student", student);
        return "backend/editstudent";
    }

    // Edit Save Student
    @PostMapping(value = "/backend/editsave")
    public String editsave(@ModelAttribute("student") Student p,
    BindingResult result){
        if(result.hasErrors()){
            System.out.println("has errors");
            return "backend/editstudent";
        }else{
            Student std = stdService.getOne(p.getId());

            std.setFirstName(p.getFirstName());
            std.setLastName(p.getLastName());
            std.setEmail(p.getEmail());

            stdService.save(std);
            return "redirect:/backend/student";
        }
    }


    // Delet Student
    @GetMapping(value = "/backend/deletestudent/{id}")
    public ModelAndView delete(@PathVariable int id){
        Student student = stdService.getOne(id);
        stdService.delete(student);
        return new ModelAndView("redirect:/backend/student");
    }

}
