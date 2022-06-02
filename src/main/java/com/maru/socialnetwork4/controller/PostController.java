package com.maru.socialnetwork4.controller;

import com.maru.socialnetwork4.model.Post;
import com.maru.socialnetwork4.model.User;
import com.maru.socialnetwork4.service.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "post", produces = "application/json")
public class PostController {
    PostServiceImpl postServiceImpl = new PostServiceImpl();

    @PostMapping(path = "upload")
    public Post upload(@RequestBody Post post) {
        return postServiceImpl.upload(post);
    }

    @PostMapping(path = "find")
    public List<Post> findPost(@RequestParam String param) {
        return postServiceImpl.findPost(param);
    }

    @PostMapping(path = "getUserPosts")
    public List<Post> findUserPosts(@RequestBody User user) {
        return postServiceImpl.getUserPosts(user);
    }

    @GetMapping(path = "getAllPosts")
    public List<Post> getAllPosts() {
        return postServiceImpl.getAllPosts();
    }
}
