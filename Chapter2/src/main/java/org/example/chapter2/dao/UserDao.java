package org.example.chapter2.dao;

import org.example.chapter2.entity.User;
import java.util.List;

public interface UserDao
{
    void save(User user);

    User findById(Integer id);

    List<User> findAll();

    List<User> findByUsername(String username);

    void update(User user);

    void deleteById(Integer id);

    int deleteAllUsers();

}
