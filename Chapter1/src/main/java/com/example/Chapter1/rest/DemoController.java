package com.example.Chapter1.rest;


import com.example.Chapter1.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
    private final Coach myCoach;
    private final Coach anotherCoach;

//     constructor injection
    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach myCoach,
                          @Qualifier("cricketCoach") Coach anotherCoach)
    {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach =anotherCoach;
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

    @GetMapping("/check")
    public String check()
    {
        return "Comparing beans: myCoach == anotherCoach ---> " + (myCoach == anotherCoach);
    }
}
