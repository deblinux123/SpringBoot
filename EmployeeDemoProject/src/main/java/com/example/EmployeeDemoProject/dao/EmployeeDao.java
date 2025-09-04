package com.example.EmployeeDemoProject.dao;

import com.example.EmployeeDemoProject.entity.Employee;
import java.util.List;

public interface EmployeeDao
{
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
