package com.example.Chapter1;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach
{
    @Override
    public String getDailyWorkout() {
        return "Practice fast 15 min";
    }
}
