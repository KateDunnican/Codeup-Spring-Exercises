package com.codeup.springblogapp;

import javax.persistence.*;

// ----------------------------------- VIEWS EXERCISE 3
@Entity
@Table (name = "posts")  // WTF?
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "title", nullable = false)
    private String title;

    @Column (name = "body", nullable = false)
    private String body;

    public Post () {
    }

    public Post (long id, String title, String body){
        this.id = id;
        this.title = title;
        this.body =  body;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
