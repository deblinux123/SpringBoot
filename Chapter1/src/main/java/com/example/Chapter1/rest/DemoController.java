package com.example.Chapter1.rest;


import com.example.Chapter1.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
    private Coach myCoach;

//     constructor injection
    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach myCoach)
    {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
    }

    // Setter injection
//    @Autowired
//    public void setMyCoach(Coach myCoach)
//    {
//        this.myCoach = myCoach;
//    }
    @GetMapping("/dailyWorkout")
    public String dailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }
}
