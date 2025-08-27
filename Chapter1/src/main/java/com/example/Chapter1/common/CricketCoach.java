package com.example.Chapter1.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
        @Override
        public String getDailyWorkout() {
            System.out.println("In Constructor: " + getClass().getSimpleName());
            return "Practice fast 15 min";
        }

}
