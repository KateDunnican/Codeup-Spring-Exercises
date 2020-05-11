package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// -------------------------------------------- LECTURE NOTES OVER SPRING VIEWS

@Controller
public class ViewLecture {

// -------------------------------- PASSING DATA TO VIEWS

    @GetMapping("/whatever")
    // Note that there's no @ResponseBody
    public String welcome() {
        return "ViewLectureHello"; // this needs to match the name of the HTML file you want it to display
    }

    @GetMapping("/whatever/{name}")
    public String sayHey(@PathVariable String name, Model model){ // the model = the view
        model.addAttribute("name", name); // assigns the input name to "name"
                                                // using the inputed model
        return "ViewLectureHello";
    }

// -------------------------------- GETTING DATA FROM VIEWS

    @GetMapping("/join")
    public String joinGet(){
        return "ViewLectureJoin";
    }

    @PostMapping("/join")
    public String joinPost(@RequestParam(name = "cohort") String cohort, Model model){
        model.addAttribute("cohort", "welcome to " + cohort + "!");
        return "ViewLectureJoin";
    }
}

