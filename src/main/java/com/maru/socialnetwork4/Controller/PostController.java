package com.maru.socialnetwork4.Controller;

import com.maru.socialnetwork4.Model.Post;
import com.maru.socialnetwork4.Model.User;
import com.maru.socialnetwork4.Service.PostService;
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

    @GetMapping(path = "find")
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

    @PostMapping(path = "react")
    public Post react(@RequestBody Post post){
        return postService.react(post);
    }

}
