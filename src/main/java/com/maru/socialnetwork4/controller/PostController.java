package com.maru.socialnetwork4.controller;

import com.maru.socialnetwork4.model.Post;
import com.maru.socialnetwork4.model.User;
import com.maru.socialnetwork4.service.PostServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    PostServiceImpl postServiceImpl = new PostServiceImpl();

    @PostMapping("/uploadPost")
    public Post upload(@RequestBody Post post) {
        return postServiceImpl.upload(post);
    }

    @PostMapping("/findPost")
    public List<Post> findPost(@RequestParam String param) {
        return postServiceImpl.findPost(param);
    }

    @PostMapping("/getUserPosts")
    public List<Post> findUserPosts(@RequestBody User user) {
        return postServiceImpl.getUserPosts(user);
    }
}
