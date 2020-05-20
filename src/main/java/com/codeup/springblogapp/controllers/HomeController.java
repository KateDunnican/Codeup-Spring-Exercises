package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// -------------------------------------------- SPRING CONTROLLERS EXERCISE 1

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String landing() {
        return "redirect:/posts";
    }
}
