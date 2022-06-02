package com.maru.socialnetwork4.dao;

import com.maru.socialnetwork4.model.Comment;
import org.hibernate.Transaction;

public class CommentDAO extends DAO {
    Transaction trans = session.getTransaction();

    public CommentDAO() {
        super();
    }

    public Comment write(Comment c) {
        try {
            if (!trans.isActive()) trans.begin();
            c.setPoints(0);
            System.out.println(c.toString());
            session.save(c);
            trans.commit();
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
