package com.codeup.springblogapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

// -------------------------------------------- SPRING CONTROLLERS EXERCISE 2

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

    @GetMapping("/mult/{x}/and/{y}")
    @ResponseBody
    public int mult(@PathVariable int x, @PathVariable int y){
        return x * y;
    }

    @GetMapping("/div/{x}/by/{y}")
    @ResponseBody
    public int div(@PathVariable int x, @PathVariable int y){
        return x / y;
    }
}