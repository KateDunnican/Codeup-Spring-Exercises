package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // says this is an MVC controller
public class HelloController{
    @GetMapping("/hello") // URL map
    @ResponseBody //whatever is returned will be displayed as HTML
    public String hello(){
        return "Hello from Spring!";
    }

}

