package com.maru.socialnetwork4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int ID;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "points", nullable = false)
    private int points;

    @ManyToOne
    @JsonBackReference(value = "comment_user")
    private User user;

    @ManyToOne
    @JsonBackReference(value = "comment_post")
    private Post post;

    public Comment() {
    }

    public Comment(int ID, String description, int points) {
        this.ID = ID;
        this.description = description;
        this.points = points;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "des: " + description + "\n"
                + "points: " + points + "\n"
                + "user: " + user + "\n"
                + "post: " + post + "\n";
    }
}
