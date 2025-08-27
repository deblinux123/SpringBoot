package com.example.Chapter1.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach
{
    @Override
    public String getDailyWorkout()
    {
        System.out.println("In Constructor: " + getClass().getSimpleName());
        return "Practice your backhand volley";
    }
}
