package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


// -------------------------------------------- LECTURE NOTES OVER SPRING CONTROLLERS


@Controller // says this is an MVC controller
public class HelloController{

    @GetMapping("/") // URL map for a doGet
    @ResponseBody //whatever is returned will be displayed as HTML
    public String landing(){
        return "Welcome to the landing page!";
    }

    // can have multiple methods in this class, one for each url map
    @GetMapping("/hello")
    @ResponseBody
    public String helloSpring(){
        return "Hello from Spring!";
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST) // longhand version of line below
    @PostMapping("/upload") //shortcut for line above (a doPost)
    public void upload(){
        // do something for uploading, idk
    }



    // *** PATH VARIABLES *** //



    @GetMapping("/hi/{name}") //whatever is put here in the url will be used as the name argument on line 32
    @ResponseBody
    public String sayHi(@PathVariable String name){ // String name here references {name} in line 30
     return "Hi, " + name;
    }

    @GetMapping("defined-ad/{id}/{version}") // can have multiples
    @ResponseBody
    public String showAd(@PathVariable long id, @PathVariable int version){ // id will be read as long, version as int
        return "showing details for ad with id: " + id + ". Version: " + version;
    }
}

