package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

// -------------------------------------------- SPRING CONTROLLERS EXERCISE 3

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsId(@PathVariable int id){
        return "view the individual post with the id: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreate(){
        return "view the form for creating a post!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postsCreateP(){ // would normally be a void, but for this exercise...
        return "create a new post or something idk"; // was this supposed to be more complex?
    }

// ----------------------------- VIEWS EXERCISE 3
    @GetMapping("/allposts")
    public String allPosts(Model model){
        ArrayList<Post> allThePosts = new ArrayList<>();

        Post Post1 = new Post();
            Post1.setTitle("Post 1");
            Post1.setBody("The body of post 1...so much body...such post");

        Post Post2 = new Post();
            Post2.setTitle("Post 2");
            Post2.setBody("The body of post 2...so much body...such post");

        allThePosts.add(Post1);
        allThePosts.add(Post2);

        model.addAttribute("allThePosts", allThePosts);

        return "posts/index";
    }

    @GetMapping("/allposts/{i}")
    public String sayHey(@PathVariable int i , Model model){
        model.addAttribute("i", i);
//        model.addAttribute("post", post);

        return "posts/show";
    }

}