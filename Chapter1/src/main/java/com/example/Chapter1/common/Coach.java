package com.example.Chapter1.common;

import org.springframework.stereotype.Component;

public interface Coach
{
    public String getDailyWorkout();

    @Component
    class CricketCoach implements Coach
    {
        @Override
        public String getDailyWorkout() {
            return "Practice fast 15 min";
        }
    }
}
