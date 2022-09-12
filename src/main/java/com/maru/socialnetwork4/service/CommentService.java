package com.maru.socialnetwork4.service;

import com.maru.socialnetwork4.model.Comment;
import com.maru.socialnetwork4.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements CustomService<Comment>{
    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment create(Comment comment) {
        return commentRepository.write(comment.getDescription(), comment.getPoints(),comment.getPost().getID() ,comment.getUser().getID());
    }

    @Override
    public Comment update(Comment comment) {
        return null;
    }

    @Override
    public Comment delete(Comment comment) {
        return null;
    }
}
