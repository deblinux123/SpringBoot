package com.example.Chapter1.config;


import com.example.Chapter1.common.Coach;
import com.example.Chapter1.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig
{
    @Bean("aquatic")
    public Coach swimCoach()
    {
        return new SwimCoach();
    }
}
