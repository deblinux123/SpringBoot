package com.example.EmployeeDemoProject.rest;



import com.example.EmployeeDemoProject.entity.Employee;
import com.example.EmployeeDemoProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId)
    {
        if (employeeService.findById(employeeId) == null)
        {
            throw new RuntimeException("Employee with id: " + employeeId + " not found");
        }

        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee)
    {
        employee.setId(null);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }
}
