package com.example.EmployeeDemoProject.rest;



import com.example.EmployeeDemoProject.entity.Employee;
import com.example.EmployeeDemoProject.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
    private final EmployeeService employeeService;

    private final ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper)
    {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
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

    @PatchMapping("/employees/{employeesId}")
    public Employee patchUpdate(@PathVariable int employeesId, @RequestBody Map<String, Object> patchPayload)
    {
        Employee employee = employeeService.findById(employeesId);

        if (employee == null)
        {
            throw new RuntimeException("Employee with id: " + employeesId + " not found");
        }

        if (patchPayload.containsKey("id"))
        {
            throw new RuntimeException("Employee id not allowed in request body -> " + employeesId);
        }
        Employee patchedEmployee = apply(patchPayload, employee);

        return employeeService.save(patchedEmployee);
    }

    private Employee apply(Map<String, Object> patchPayload, Employee employee)
    {
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);

        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}
