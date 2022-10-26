package com.maru.socialnetwork4.dao;

import com.maru.socialnetwork4.model.User;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO {
    Transaction trans = session.getTransaction();

    public UserDAO() {
        super();
    }

    public User check(User user) {
        try {
            String hql = "FROM User WHERE username = :un AND password = :pw";
            Query query = session.createQuery(hql);
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
            Query query = session.createQuery(hql);
            query.setParameter("un", username);
            List<User> users = new ArrayList<>(query.list());
            return users.size();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public User add(User user) {
        try {
            User newUser = new User(
                    user.getUsername(),
                    user.getPassword(),
                    (user.getfullName() == null ? "*chua dang ky" : user.getfullName()),
                    (user.getDob() == null ? "*chua dang ky" : user.getDob()),
                    "Join at " + LocalDateTime.now()
            );
            if (!trans.isActive()) trans.begin();
            session.save(newUser);
            trans.commit();
            return newUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User update(User user) {
        try {
            System.out.println(user.toString());
            if (!trans.isActive()) trans.begin();

            String hql = "UPDATE User SET " +
                    "dob = :dob, " +
                    "fullName = :fn, " +
                    "note = :note " +
                    "WHERE username = :un";
            Query query = session.createQuery(hql);
            query.setParameter("dob", user.getDob());
            query.setParameter("fn", user.getfullName());
            query.setParameter("note", user.getNote());
            query.setParameter("un", user.getUsername());
            query.executeUpdate();

            trans.commit();
            session.clear();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
