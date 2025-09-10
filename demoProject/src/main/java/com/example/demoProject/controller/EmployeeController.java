package com.example.demoProject.controller;


import com.example.demoProject.entity.Employee;
import com.example.demoProject.servce.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController
{
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String list(Model model)
    {
        List<Employee> employees = employeeService.findAll();

        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/showFormForAdd";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model)
    {
        Employee employee = employeeService.findByID(theId);

        model.addAttribute("employee", employee);

        return "employees/showFormForAdd";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId)
    {
        employeeService.deleteById(theId);

        return "redirect:/employees/list";
    }
}
