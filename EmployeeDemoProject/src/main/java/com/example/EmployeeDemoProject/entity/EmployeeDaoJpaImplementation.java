package com.example.EmployeeDemoProject.entity;

import com.example.EmployeeDemoProject.dao.EmployeeDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDaoJpaImplementation implements EmployeeDao
{
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImplementation(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll()
    {
        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // execute the result
        List<Employee> employees = query.getResultList();

        // return the result
        return employees;
    }

    @Override
    public Employee findById(int id) {

        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        // find the employee
        Employee findEmployee = entityManager.find(Employee.class, id);
        // remove the employe that wee find by there id
        entityManager.remove(findEmployee);
    }
}
