package com.example.Chapter1.common;

public class SwimCoach implements Coach
{
    public SwimCoach()
    {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 100 meters as warm up.";
    }
}
