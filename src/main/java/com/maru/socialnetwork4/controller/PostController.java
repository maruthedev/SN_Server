package com.maru.socialnetwork4.controller;

import com.maru.socialnetwork4.model.Post;
import com.maru.socialnetwork4.model.User;
import com.maru.socialnetwork4.service.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "post", produces = "application/json")
public class PostController {
    PostServiceImpl postServiceImpl = new PostServiceImpl();

    @PostMapping(value = "/upload")
    public Post upload(@RequestBody Post post) {
        return postServiceImpl.upload(post);
    }

    @PostMapping("/find")
    public List<Post> findPost(@RequestParam String param) {
        return postServiceImpl.findPost(param);
    }

    @PostMapping("/getUserPosts")
    public List<Post> findUserPosts(@RequestBody User user) {
        return postServiceImpl.getUserPosts(user);
    }
}
