package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// -------------------------------------------- POST CONTROLLER

@Controller
public class PostController {

    private final UserRepository userDao; // creates an instance of the UserRepository Interface
    private final PostRepository postDao; // creates an instance of the PostRepository Interface

    public PostController(UserRepository userDao, PostRepository postDao) { // Constructor for the PostController class
        this.postDao = postDao;
        this.userDao = userDao;
    }

    //  SHOW ALL POSTS
    @GetMapping("/posts")
    public String showAll(Model model) {
        model.addAttribute("allThePosts", postDao.findAll());
        return "posts/index";
    }

    // SHOW ONE POST
    @GetMapping("/posts/{id}")
    public String showOne(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    // EDIT ONE POST PAGE
    @GetMapping("/posts/edit/{id}")
    public String editPage(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

        // EDITING ONE POST
        @PostMapping("/posts/edit/{id}")
        public String editedPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, @PathVariable long id) {

            Post editedPost = postDao.getOne(id);
            editedPost.setTitle(title);
            editedPost.setBody(body);

            postDao.save(editedPost);

            return "redirect:/posts/" + id; //go to endpoint (redirects to showOne method)
        }

    // DELETE
    @PostMapping("/posts/{id}")
    public String deletedOne(@PathVariable long id) {
        Post postToDelete = postDao.getOne(id);
        postDao.delete(postToDelete);
        return "redirect:/posts"; //go to endpoint (redirects to showAll method)
    }

    // CREATE POST PAGE
    @GetMapping("/posts/create")
    public String postsCreate() {
        return "posts/create";
    }
        // CREATING POST
        @PostMapping("/posts/create")
        public String postsCreateP(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {

            Post newPost = new Post();
            newPost.setTitle(title);
            newPost.setBody(body);
            newPost.setUser(userDao.getOne(1L)); // Make this dynamic later

            postDao.save(newPost);

            return "redirect:/posts"; //go to endpoint (redirects to showAll method)
        }
}