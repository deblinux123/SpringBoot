package org.example.chapter2.dao;

import jakarta.persistence.EntityManager;

import org.example.chapter2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class UserDaoImplement implements UserDao
{
    private EntityManager entityManager;

    @Autowired
    public UserDaoImplement(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(User user)
    {
        entityManager.persist(user);
    }
}
