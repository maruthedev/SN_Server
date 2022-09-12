package com.maru.socialnetwork4.controller;

import com.maru.socialnetwork4.model.Comment;
import com.maru.socialnetwork4.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "comment", produces = "application/json")
@CrossOrigin
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping(path = "write")
    public Comment comment(@RequestBody Comment c){
        return commentService.create(c);
    }
}
