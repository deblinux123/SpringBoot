package org.example.chapter2;

import org.example.chapter2.dao.UserDaoImplement;
import org.example.chapter2.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;



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
//            createUser(userDao);
//            readUsers(userDao);
//            queryForUsers(userDao);
            queryForUsersByUsername(userDao);
        };
    }

    private void queryForUsersByUsername(UserDaoImplement userDao)
    {
        // get list of users
        List<User> users = userDao.findByUsername("Farid");

        System.out.println(users.size() + " users found ... ");
        // display the results
        for (User user: users)
        {
            System.out.println(user);
        }
    }

    private void queryForUsers(UserDaoImplement userDao)
    {
        // get list of users
        List<User> users = userDao.findAll();

        for (User user : users)
        {
            System.out.println(user);
        }
    }

    public void readUsers(UserDaoImplement userDao)
    {
        int userId = 3;
        User user = userDao.findById(userId);

        System.out.println("Retriveing user id = " + userId);

        System.out.println("Found The user with username: " + user.getUsername());
    }

    private void createUser(UserDaoImplement userDao)
    {
        System.out.println("Creating user...");
        User user = new User("Babak", "BabakK123@gmail.com", "myPass");
        userDao.save(user);

        System.out.println("User created With id " + user.getId());
    }
}
