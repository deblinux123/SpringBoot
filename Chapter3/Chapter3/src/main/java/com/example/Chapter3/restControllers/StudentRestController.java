package com.example.Chapter3.restControllers;


import com.example.Chapter3.entity.Students;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController
{
    @GetMapping("/students")
    public List<Students> getStudents()
    {
        List<Students> students = new ArrayList<>();
        students.add(new Students("John", "Doe"));
        students.add(new Students("Farid","Kaki"));
        students.add(new Students("ASma", "Azizi"));
        return students;
    }
}
