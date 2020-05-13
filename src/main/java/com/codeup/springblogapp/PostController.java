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


// ---------- STUFF FOR REPO AND JPA EXERCISE (dependency injection) --------
    private final PostRepository postDao; // creates an instance of the PostRepository Interface

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String showAll(Model model) {
        model.addAttribute("allThePosts", postDao.findAll());
        return "posts/index";
    }

//    @GetMapping("/posts/edit")
//    public String editOne(Model model) {
//        model.addAttribute("allThePosts", postDao.save());
//        return "posts/index";
//    }
//
//    @GetMapping("/posts/delete")
//    public String deleteOne(Model model) {
//        model.addAttribute("allThePosts", postDao.delete());
//        return "posts/index";
//    }

    //put edit and delete here

//    ------------------------------------------------------------------------

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
        public String postsCreateP(){
            return "create a new post or something idk"; // was this supposed to be more complex?
        }

// ----------------------------- VIEWS EXERCISE 3
    @GetMapping("/allposts")
    public String allPosts(Model model){
        ArrayList<Post> allThePosts = new ArrayList<>();

        Post Post1 = new Post();
            Post1.setId(1);
            Post1.setTitle("Post 1");
            Post1.setBody("The body of post 1...so much body...such post");

        Post Post2 = new Post();
            Post2.setId(2);
            Post2.setTitle("Post 2");
            Post2.setBody("The body of post 2...so much body...such post");

        allThePosts.add(Post1);
        allThePosts.add(Post2);

        model.addAttribute("allThePosts", allThePosts);

        return "posts/index";
    }

    @GetMapping("/allposts/{i}")
    public String sayHey(@PathVariable long i , Model model){

        ArrayList<Post> allThePosts = new ArrayList<>();

        Post Post1 = new Post();
        Post1.setId(1);
        Post1.setTitle("Post 1");
        Post1.setBody("The body of post 1...so much body...such post");

        Post Post2 = new Post();
        Post2.setId(2);
        Post2.setTitle("Post 2");
        Post2.setBody("The body of post 2...so much body...such post");

        allThePosts.add(Post1);
        allThePosts.add(Post2);

        model.addAttribute("allThePosts", allThePosts);
        model.addAttribute("i", i);

        return "posts/show";
    }
}