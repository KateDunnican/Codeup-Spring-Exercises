package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

// -------------------------------------------- SPRING CONTROLLERS EXERCISE 2

@Controller
public class MathController {

    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public String add(@PathVariable int x, @PathVariable int y){
        int theAnswer = x + y;
        return "" + theAnswer;
    }

    @GetMapping("/sub/{x}/from/{y}")
    @ResponseBody
    public String sub(@PathVariable int x, @PathVariable int y){
        int theAnswer = x - y;
        return "" + theAnswer;
    }

    @GetMapping("/multi/{x}/and/{y}")
    @ResponseBody
    public String multi(@PathVariable int x, @PathVariable int y){
        int theAnswer = x * y;
        return "" + theAnswer;
    }

    @GetMapping("/div/{x}/by/{y}")
    @ResponseBody
    public String div(@PathVariable int x, @PathVariable int y){
        int theAnswer = x / y;
        return "" + theAnswer;
    }
}