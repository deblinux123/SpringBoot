package com.example.Chapter1.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach
{
    @Override
    public String getDailyWorkout()
    {
        System.out.println("In constructor: " + getClass().getSimpleName());
        return "Run a hard 5K!";
    }
}
