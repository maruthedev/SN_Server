package com.maru.socialnetwork4.controller;

import com.maru.socialnetwork4.model.Comment;
import com.maru.socialnetwork4.service.CommentServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "comment", produces = "application/json")
public class CommentController {
    CommentServiceImpl commentServiceImpl = new CommentServiceImpl();

    @PostMapping(path = "write")
    public Comment comment(@RequestBody Comment c){
        return commentServiceImpl.write(c);
    }
}
