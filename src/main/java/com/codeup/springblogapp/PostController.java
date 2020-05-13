package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// -------------------------------------------- SPRING CONTROLLERS EXERCISE 3

@Controller
public class PostController {

// ---------- STUFF FOR REPO AND JPA EXERCISE (dependency injection) --------
    private final PostRepository postDao; // creates an instance of the PostRepository Interface

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }
//  SHOW ALL POSTS - DONE
    @GetMapping("/posts")
    public String showAll(Model model) {
        model.addAttribute("allThePosts", postDao.findAll());
        return "posts/index";
    }
        // SHOW AN INDIVIDUAL POST - DONE
        @GetMapping("/posts/{id}")
        public String showOne(@PathVariable long id,  Model model) {
            model.addAttribute("post", postDao.getOne(id));
            return "posts/show";
        }
            // EDIT FORM FOR INDIVIDUAL POST - DONE
            @GetMapping("/posts/edit/{id}")
            public String editOne(@PathVariable long id, Model model){
                model.addAttribute("post", postDao.getOne(id));
                return "posts/editORdelete";
            }
                // EDITED INDIVIDUAL POST - IN PROGRESS
                @PostMapping("/posts/edit/{id}")
                public String editedOne(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, @PathVariable long id, Model model){

                    Post editedPost = postDao.getOne(id);
                        editedPost.setTitle(title);
                        editedPost.setBody(body);

                    postDao.save(editedPost);

                    return "redirect:/posts/" + id; //go to endpoint
                }
            // DELETE INDIVIDUAL POST - Don't need?
//            @GetMapping("/posts/delete/{id}")
//            public String deleteOne(@PathVariable long id, Model model) {
//                model.addAttribute("post", postDao.getOne(id));
//                return "posts/editORdelete";
//            }
                // YOU DELETED IT PAGE
                @PostMapping("/posts/{id}")
                @ResponseBody
                public String deletedOne(@PathVariable long id){
                    return "You have deleted" + id;
                }

//    ------------------------------------------------------------------------

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
    // DONE DON'T TOUCH THEM, THEY WORK
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