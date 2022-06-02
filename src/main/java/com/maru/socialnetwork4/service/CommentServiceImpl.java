package com.maru.socialnetwork4.service;

import com.maru.socialnetwork4.dao.CommentDAO;
import com.maru.socialnetwork4.model.Comment;

public class CommentServiceImpl implements CommentService{
    @Override
    public Comment write(Comment c) {
        return new CommentDAO().write(c);
    }
}
