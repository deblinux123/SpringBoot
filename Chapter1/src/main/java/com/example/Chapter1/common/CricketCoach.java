package com.example.Chapter1.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

        public CricketCoach()
        {
            System.out.println("In Constructor: " + getClass().getSimpleName());
        }

        @PostConstruct
        public void doMystartUpStauff()
        {
            System.out.println("In doMystartUpStuff(): " + getClass().getSimpleName());
        }

        @PreDestroy
        public void doMyCleanUpStuff()
        {
            System.out.println("In doMyCleanUpStuff(): " + getClass().getSimpleName());
        }
        @Override
        public String getDailyWorkout() {
            return "Practice fast 15 min";
        }

}
