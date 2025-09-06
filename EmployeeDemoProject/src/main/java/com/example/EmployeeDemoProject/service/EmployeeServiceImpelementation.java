package com.example.EmployeeDemoProject.service;


import com.example.EmployeeDemoProject.dao.EmployeeRepository;
import com.example.EmployeeDemoProject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpelementation implements EmployeeService
{
    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpelementation(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll()
    {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id)
    {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent())
        {
            return employee.get();
        }
        else {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id)
    {
        employeeRepository.deleteById(id);
    }
}
