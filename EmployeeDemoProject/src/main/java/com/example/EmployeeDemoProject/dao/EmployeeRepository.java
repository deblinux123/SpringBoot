package com.example.EmployeeDemoProject.dao;

import com.example.EmployeeDemoProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public class EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
