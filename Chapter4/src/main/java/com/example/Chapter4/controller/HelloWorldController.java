package com.example.Chapter4.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController
{
    @GetMapping("/showform")
    public String showForm()
    {
        return "showform";
    }

    @RequestMapping("/proccessForm")
    public String proccessForm()
    {
        return "helloworld";
    }

    @RequestMapping("/proccessFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model)
    {
        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "Hello, " + theName;
        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/proccessFormV3")
    public String proccessFromV3(@RequestParam("studentName") String theName, Model model)
    {
        theName = theName.toUpperCase();

        String result = "Hello V3, " + theName;

        model.addAttribute("message", result);

        return "helloworld";
    }
}
