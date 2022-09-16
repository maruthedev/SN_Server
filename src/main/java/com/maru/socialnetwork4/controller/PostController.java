package com.maru.socialnetwork4.controller;

import com.maru.socialnetwork4.model.Post;
import com.maru.socialnetwork4.model.User;
import com.maru.socialnetwork4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "post", produces = "application/json")
@CrossOrigin
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping(path = "upload")
    public Post upload(@RequestBody Post post) {
        return postService.create(post);
    }

    @PostMapping(path = "find")
    public List<Post> findPost(@RequestParam String param) {
        return postService.findPostByTitleOrUsername(param);
    }

    @PostMapping(path = "getUserPosts")
    public List<Post> findUserPosts(@RequestBody User user) {
        return postService.getUserPost(user);
    }

    @GetMapping(path = "getAllPosts")
    public List<Post> getAllPosts() {
        return postService.getAllPost();
    }
}
