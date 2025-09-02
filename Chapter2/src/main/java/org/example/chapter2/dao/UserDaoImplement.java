package org.example.chapter2.dao;

import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import org.example.chapter2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class UserDaoImplement implements UserDao
{
    private final EntityManager entityManager;

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

    @Override
    public User findById(Integer id)
    {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll()
    {
        // create query
        TypedQuery<User> query = entityManager.createQuery("FROM User order by username desc", User.class);

        // return the result
        return query.getResultList();
    }

    @Override
    public List<User> findByUsername(String username) {
        // create query
        TypedQuery<User> query = entityManager.createQuery("FROM User WHERE username=:username",User.class);

        // set query parameter
        query.setParameter("username", username);

        // return the result
        return query.getResultList();
    }
}
