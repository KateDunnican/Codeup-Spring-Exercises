package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

// -------------------------------- VIEWS EXERCISE 1

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice")
    public String dicePage(){
        return "DiceRoll";
    }

    @GetMapping("/roll-dice/{n}")
    @ResponseBody
    public String diceGuessPage(@PathVariable int n, Model model){
        model.addAttribute("n", n);

        Random random = new Random();
        int theRoll = random.nextInt(7);

        if (n == theRoll){
            return "You guessed " + n + ", and the roll was: " + theRoll + ".  Yay!";
        }
        else {
            return "You guessed " + n + ", and the roll was: " + theRoll + ".  Sad day!";
        }

    }
}
