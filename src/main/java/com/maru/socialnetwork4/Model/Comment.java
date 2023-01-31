package com.maru.socialnetwork4.Model;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "points", nullable = false)
    private int points;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    public Comment() {
    }

    public Comment(int id, String description, int points) {
        this.id = id;
        this.description = description;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
