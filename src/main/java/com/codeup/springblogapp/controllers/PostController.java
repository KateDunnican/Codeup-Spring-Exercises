package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.EmailService;
import com.codeup.springblogapp.models.Post;

import com.codeup.springblogapp.models.User;

import com.codeup.springblogapp.models.UserWithRoles;
import com.codeup.springblogapp.repositories.PostRepository;
import com.codeup.springblogapp.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// -------------------------------------------- POST CONTROLLER

@Controller
public class PostController {
    private final EmailService emailService;
    private final UserRepository userDao; // creates an instance of the UserRepository Interface
    private final PostRepository postDao; // creates an instance of the PostRepository Interface

    public PostController(EmailService emailService, UserRepository userDao, PostRepository postDao) { // Constructor for the PostController class
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User author = postDao.getOne(id).getUser();

        if (author.getId() == loggedInUser.getId()) {
            return "posts/edit";
        } else {
            return "posts/ohNoGirl";
            // return "redirect:/login?logout";
        }
    }

        // EDITING ONE POST ---------- Modified Way
        @PostMapping("/posts/edit/{id}")
        public String editedPost(@ModelAttribute Post post, @PathVariable long id) {

            User author = postDao.getOne(id).getUser();
            post.setUser(author);

            postDao.save(post);
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
    public String postsCreate(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

        // CREATING POST
        @PostMapping("/posts/create")
        public String postsCreateP(@ModelAttribute Post post) {
            User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            post.setUser(author);
            postDao.save(post);

            String subject = "A new post has been created: " + post.getTitle();
            String body = post.getBody();
            emailService.prepareAndSend(post, subject, body);

            return "redirect:/posts"; //go to endpoint (redirects to showAll method)
        }
}