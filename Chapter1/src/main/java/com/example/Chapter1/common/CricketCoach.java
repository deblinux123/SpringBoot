package com.example.Chapter1.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
        @Override
        public String getDailyWorkout() {
            System.out.println("In Constructor: " + getClass().getSimpleName());
            return "Practice fast 15 min";
        }

}
