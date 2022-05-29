package com.maru.socialnetwork4.dao;

import com.maru.socialnetwork4.model.Post;
import com.maru.socialnetwork4.model.User;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
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

    public List<Post> findPost(String param) {
        try {
            String hql = "FROM Post WHERE (title LIKE :p OR user.username LIKE :p)";
            Query query = session.createQuery(hql);
            query.setParameter("p", "%" + param + "%");
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Post> getUserPosts(User user) {
        try{
            String hql = "FROM Post WHERE user.id = :i";
            Query query = session.createQuery(hql);
            query.setParameter("i", user.getID());
            return query.list();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
