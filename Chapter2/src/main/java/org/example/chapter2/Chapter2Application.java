package org.example.chapter2;

import org.example.chapter2.dao.UserDaoImplement;
import org.example.chapter2.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Chapter2Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter2Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserDaoImplement userDao)
    {
        return runner ->
        {
            createUser(userDao);
        };
    }

    private void createUser(UserDaoImplement userDao)
    {
        System.out.println("Creating user...");
        User user = new User("New User", "newUsername@gmail.com", "testing123");
        userDao.save(user);

        System.out.println("User created With id " + user.getId());
    }
}
