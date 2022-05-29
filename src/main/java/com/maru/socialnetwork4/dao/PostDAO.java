package com.maru.socialnetwork4.dao;

import com.maru.socialnetwork4.model.Post;
import com.maru.socialnetwork4.model.User;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends DAO {
    Transaction trans = session.getTransaction();

    public PostDAO() {
        super();
    }

    public Post upload(Post post) {
        try {
            post.setDate("" + LocalDateTime.now());
            System.out.println(post.getDate());

            if (!trans.isActive()) trans.begin();
            session.save(post);
            trans.commit();
            return post;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
