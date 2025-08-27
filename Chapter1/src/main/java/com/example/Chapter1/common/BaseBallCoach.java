package com.example.Chapter1.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach
{
    public BaseBallCoach()
    {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout()
    {
        return "Spend 30 min in batting practice";
    }
}
