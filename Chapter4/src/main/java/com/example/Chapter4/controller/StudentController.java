package com.example.Chapter4.controller;


import com.example.Chapter4.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController
{
    @GetMapping("/studentForm")
    public String studentForm(Model model)
    {
        Student student = new Student();

        model.addAttribute("student", student);

        return "student-form";
    }
}
