package com.example.EmployeeDemoProject.dao;

import com.example.EmployeeDemoProject.entity.Employee;
import java.util.List;

public interface EmployeeDao
{
    List<Employee> findAll();
}
