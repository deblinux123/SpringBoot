package com.example.Chapter4.controller;


import com.example.Chapter4.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController
{
    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/studentForm")
    public String studentForm(Model model)
    {
        Student student = new Student();

        model.addAttribute("student", student);
        model.addAttribute("countries", countries);

        return "student-form";
    }

    @PostMapping("/proccessStudentForm")
    public String proccessStudentForm(@ModelAttribute("student") Student student)
    {
        System.out.println("Student Information " +
                student.getFirstName() +
                " " +
                student.getLastName() +
                " Country " +
                student.getCountry());
        return "student-confirmation";
    }

}
