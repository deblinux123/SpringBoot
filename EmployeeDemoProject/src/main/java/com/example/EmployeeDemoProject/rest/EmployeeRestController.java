package com.example.EmployeeDemoProject.rest;


import com.example.EmployeeDemoProject.dao.EmployeeDao;
import com.example.EmployeeDemoProject.entity.Employee;
import com.example.EmployeeDemoProject.service.EmployeeService;
import com.example.EmployeeDemoProject.service.EmployeeServiceImpelementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }
}
