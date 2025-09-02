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
//            queryForUsersByUsername(userDao);
//            updateUses(userDao);
//            deleteUser(userDao);
            deleteAll(userDao);
        };
    }

    private void deleteAll(UserDaoImplement userDao)
    {
        System.out.println("Deleting all users...");
        int numRows = userDao.deleteAllUsers();
        System.out.println("Deleted " + numRows + " users.");
    }

    private void deleteUser(UserDaoImplement userDao)
    {
        int userId = 2;
        System.out.println("Deleting user with id " + userId);
        userDao.deleteById(userId);
        System.out.println("Done.");
    }

    private void updateUses(UserDaoImplement userDao)
    {
        // retrieve the user based on id
        int userId = 3;
        System.out.println("Getting user with id: " + userId);
        User user = userDao.findById(userId);

        // change the username
        System.out.println("Updating user ...");
        user.setUsername("My New USER NAME");

       // update the student
        userDao.update(user);

        // display the result
        System.out.println("User with id: " + userId + " and new username \"" + user.getUsername() + "\" updated");
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
