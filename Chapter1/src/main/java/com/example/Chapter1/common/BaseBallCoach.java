package com.example.Chapter1.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach
{
    @Override
    public String getDailyWorkout()
    {
        System.out.println("In constructor: " + getClass().getSimpleName());
        return "Spend 30 min in batting practice";
    }
}
