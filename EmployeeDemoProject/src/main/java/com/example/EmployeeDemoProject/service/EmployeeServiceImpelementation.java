package com.example.EmployeeDemoProject.service;

import com.example.EmployeeDemoProject.dao.EmployeeDao;
import com.example.EmployeeDemoProject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public class EmployeeServiceImpelementation implements EmployeeService
{
    private final EmployeeDao employeeDao;


    @Autowired
    public EmployeeServiceImpelementation(EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll()
    {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }
}
