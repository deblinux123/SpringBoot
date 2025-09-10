package com.example.demoProject.dao;

import com.example.demoProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
    List<Employee> findAllByOrderByLastNameAsc();
}
