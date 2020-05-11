package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// -------------------------------------------- SPRING CONTROLLERS EXERCISE 1

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String landing() {
        return "This is the landing page!";
    }
}
