package com.maru.socialnetwork4.Dao;

import com.maru.socialnetwork4.Model.User;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<User> {
    Transaction trans = getSession().getTransaction();

    public UserDAO() {
        super();
    }

    public User check(User user) {
        try {
            String hql = "FROM User WHERE username = :un AND password = :pw";
            Query query = getSession().createQuery(hql);
            query.setParameter("un", user.getUsername());
            query.setParameter("pw", user.getPassword());
            ArrayList<User> re = new ArrayList<>(query.list());
            if (re.size() == 1) return re.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public int countUsernamesLike(String username) {
        try {
            String hql = "FROM User WHERE username = :un";
            Query query = getSession().createQuery(hql);
            query.setParameter("un", username);
            List<User> users = new ArrayList<>(query.list());
            return users.size();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public User create(User user) {
        try {
            int userCount = countUsernamesLike(user.getUsername());
            if (userCount > 0) {
                return null;
            }
            user.setDob("*chua dang ky");
            user.setFullName("*chua dang ky");
            user.setNote("*chua dang ky");
            User newUser = new User(
                    user.getUsername(),
                    user.getPassword(),
                    (user.getFullName() == null ? "*chua dang ky" : user.getFullName()),
                    (user.getDob() == null ? "*chua dang ky" : user.getDob()),
                    "Join at " + LocalDateTime.now()
            );
            if (!trans.isActive()) trans.begin();
            getSession().save(newUser);
            trans.commit();
            return newUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User update(User user) {
        try {
            if (!trans.isActive()) trans.begin();

            String hql = "UPDATE User SET " +
                    "dob = :dob, " +
                    "fullName = :fn, " +
                    "note = :note " +
                    "WHERE username = :un";
            Query query = getSession().createQuery(hql);
            query.setParameter("dob", user.getDob());
            query.setParameter("fn", user.getFullName());
            query.setParameter("note", user.getNote());
            query.setParameter("un", user.getUsername());
            query.executeUpdate();

            trans.commit();
            getSession().clear();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User delete(User user) {
        return null;
    }

    public User loadUserByUsername(String username) {
        try {
            String hql = "FROM User WHERE username = :u";
            Query query = getSession().createQuery(hql);
            query.setParameter("u", username);
            List<User> list = new ArrayList<>(query.list());
            return list.get(0);
        } catch (Exception e) {
            return null;
        }
    }


    public User loadUserById(int id) {
        try {
            String hql = "FROM User WHERE id = :id";
            Query query = getSession().createQuery(hql);
            query.setParameter("id", id);
            List<User> list = new ArrayList<>(query.list());
            return list.get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
