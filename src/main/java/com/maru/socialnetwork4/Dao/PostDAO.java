package com.maru.socialnetwork4.Dao;

import com.maru.socialnetwork4.Model.Post;
import com.maru.socialnetwork4.Model.User;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends DAO<Post> {
    Transaction trans = getSession().getTransaction();

    public PostDAO() {
        super();
    }

    @Override
    public Post create(Post post) {
        try {
            post.setDate("" + LocalDateTime.now());
            post.setPoints(0);
            post.setComments(new ArrayList<>());

            if (!trans.isActive()) trans.begin();
            getSession().save(post);
            trans.commit();
            return post;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public Post delete(Post post) {
        return null;
    }

    public List<Post> findPost(String param) {
        try {
            String hql = "FROM Post WHERE (title LIKE :p OR user.username LIKE :p)";
            Query query = getSession().createQuery(hql);
            query.setParameter("p", "%" + param + "%");
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Post>  getUserPosts(User user) {
        try {
            String hql = "FROM Post WHERE user.username = :un";
            Query query = getSession().createQuery(hql);
            query.setParameter("un", user.getUsername());
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Post> getAllPosts() {
        try {
            String hql = "FROM Post";
            Query query = getSession().createQuery(hql);
            return (List<Post>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Post react(Post post) {
        try {
            if (!trans.isActive()) trans.begin();
            String hql = "UPDATE Post SET " +
                    "points = :p " +
                    "WHERE id = :id";
            Query query = getSession().createQuery(hql);
            query.setParameter("p",post.getPoints());
            query.setParameter("id", post.getId());
            query.executeUpdate();
            trans.commit();
            getSession().clear();
            return post;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
