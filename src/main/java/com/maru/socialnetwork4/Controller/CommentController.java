package com.maru.socialnetwork4.Controller;

import com.maru.socialnetwork4.Model.Comment;
import com.maru.socialnetwork4.Service.CommentService;
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
