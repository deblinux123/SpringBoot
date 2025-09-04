package com.example.EmployeeDemoProject.rest;


import com.example.EmployeeDemoProject.dao.EmployeeDao;
import com.example.EmployeeDemoProject.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
    private EmployeeDao employeeDao;

    public EmployeeRestController(EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeDao.findAll();
    }
}
