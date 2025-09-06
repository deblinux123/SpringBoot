package com.example.EmployeeDemoProject.dao;

import com.example.EmployeeDemoProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
}
