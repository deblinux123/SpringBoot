package com.example.EmployeeDemoProject.entity;

import com.example.EmployeeDemoProject.dao.EmployeeDao;
import jakarta.persistence.Entity;
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
}
