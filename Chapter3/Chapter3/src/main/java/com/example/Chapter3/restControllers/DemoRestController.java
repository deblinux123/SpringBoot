package com.example.Chapter3.restControllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController
{
    @GetMapping("/hello")
    public String sayHello()
    {
        return "<h1>Hello World</h1>";
    }
}
