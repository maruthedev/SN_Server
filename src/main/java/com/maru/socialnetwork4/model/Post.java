package com.maru.socialnetwork4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int ID;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "date")
    private String date;
    @Column(name = "points")
    private int points;

    @ManyToOne
    @JsonBackReference(value = "post_user")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    public Post() {
        this.comments = new ArrayList<>();
        this.date = "" + LocalDateTime.now();
        this.points = 0;
    }

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
        this.comments = new ArrayList<>();
        this.date = "" + LocalDateTime.now();
        this.points = 0;
    }

    public Post(String title, String description, String date, int points, User user, List<Comment> comments) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.points = points;
        this.user = user;
        this.comments = comments;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "title: " + title + "\n"
                + "des: " + description + "\n"
                + "date: " + date + "\n"
                + "points: " + points + "\n"
                + "user: " + user + "\n";
    }
}
