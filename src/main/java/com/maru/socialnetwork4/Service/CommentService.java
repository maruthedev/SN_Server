package com.maru.socialnetwork4.Service;

import com.maru.socialnetwork4.Dao.CommentDAO;
import com.maru.socialnetwork4.Model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements CustomService<Comment>{
    private final static CommentDAO commentDAO = new CommentDAO();

    @Override
    public Comment create(Comment comment) {
        return commentDAO.create(comment);
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
