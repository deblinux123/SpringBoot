package com.example.Chapter1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//        (
//                scanBasePackages = {
//                        "com.example.Chapter1",
//                        "com.example.util"
//                }
//        )

@SpringBootApplication
public class Chapter1Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter1Application.class, args);
	}

}
