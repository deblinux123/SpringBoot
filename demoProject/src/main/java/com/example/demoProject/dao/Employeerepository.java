package com.example.demoProject.dao;

import com.example.demoProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Employeerepository extends JpaRepository<Employee, Integer>
{

}
