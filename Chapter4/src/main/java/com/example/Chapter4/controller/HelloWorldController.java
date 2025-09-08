package com.example.Chapter4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController
{
    @RequestMapping("/showform")
    public String showForm()
    {
        return "showform";
    }

    @RequestMapping("/proccessForm")
    public String proccessForm()
    {
        return "helloworld";
    }

}
