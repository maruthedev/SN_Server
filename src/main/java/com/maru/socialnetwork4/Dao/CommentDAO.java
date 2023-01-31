package com.maru.socialnetwork4.Dao;

import com.maru.socialnetwork4.Model.Comment;
import org.hibernate.Transaction;

public class CommentDAO extends DAO<Comment> {
    Transaction trans = getSession().getTransaction();

    public CommentDAO() {
        super();
    }

    @Override
    public Comment create(Comment comment) {
        try {
            if (!trans.isActive()) trans.begin();
            comment.setPoints(0);
            getSession().save(comment);
            trans.commit();
            return comment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
