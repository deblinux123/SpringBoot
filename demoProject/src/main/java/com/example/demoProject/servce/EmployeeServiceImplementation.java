package com.example.demoProject.servce;


import com.example.demoProject.dao.EmployeeRepository;
import com.example.demoProject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImplementation implements EmployeeService
{
    private EmployeeRepository employeeRepo;


    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findByID(int theId) {
        Optional<Employee> result = employeeRepo.findById(theId);

        Employee employee = null;

        if (result.isPresent())
        {
            employee = result.get();
        }else
        {
            throw new RuntimeException("Employee not found");
        }

        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepo.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepo.deleteById(theId);
    }
}
