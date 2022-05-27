package com.maru.socialnetwork4.dao;

import com.maru.socialnetwork4.model.User;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserDAO extends DAO {
    Transaction trans = session.getTransaction();

    public UserDAO() {
        super();
    }

    public User check(User user) {
        try {
            Query query = session.createQuery("FROM User WHERE username = :un AND password = :pw");
            query.setParameter("un", user.getUsername());
            query.setParameter("pw", user.getPassword());
            ArrayList<User> re = new ArrayList<>(query.list());
            if (re.size() == 1) {
                return re.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public User add(User user) {
        try {
            Query query = session.createQuery("FROM User WHERE username = :un");
            query.setParameter("un", user.getUsername());
            ArrayList<User> re = new ArrayList<>(query.list());
            if (re.size() == 0) {
                User newUser = new User(
                        user.getUsername(),
                        user.getPassword(),
                        (user.getFullName() == null? "*chua dang ky" : user.getFullName()),
                        (user.getDob() == null? "*chua dang ky" : user.getDob()),
                        "Join at " + LocalDateTime.now()
                );

                System.out.println("username: " + newUser.getUsername());
                System.out.println("password: " + newUser.getPassword());
                System.out.println("fullname: " + newUser.getFullName());
                System.out.println("dob: " + newUser.getDob());
                System.out.println("note: " + newUser.getNote());

                if (!trans.isActive()) trans.begin();
                session.save(newUser);
                trans.commit();

                return newUser;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
