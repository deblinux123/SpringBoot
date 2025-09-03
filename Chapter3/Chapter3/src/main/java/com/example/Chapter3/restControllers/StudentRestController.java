package com.example.Chapter3.restControllers;


import com.example.Chapter3.entity.Students;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController
{
    private List<Students> students;

    @PostConstruct
    public void loadData()
    {
        students = new ArrayList<>();
        students.add(new Students("John", "Doe"));
        students.add(new Students("Farid","Kaki"));
        students.add(new Students("ASma", "Azizi"));
    }

    @GetMapping("/students")
    public List<Students> getStudents()
    {
        return students;
    }

    @GetMapping("students/{studentsId}")
    public Students getStudent(@PathVariable int studentsId)
    {
        if ((studentsId > students.size()) || (studentsId < 0))
        {
            throw new StudentNotFoundException("Student id not found - " + studentsId);
        }
        return students.get(studentsId);
    }
}
