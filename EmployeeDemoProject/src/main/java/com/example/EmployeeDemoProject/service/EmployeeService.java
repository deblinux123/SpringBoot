package com.example.EmployeeDemoProject.service;

import com.example.EmployeeDemoProject.entity.Employee;
import java.util.List;


public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}


