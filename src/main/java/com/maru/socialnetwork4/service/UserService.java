package com.maru.socialnetwork4.service;

import com.maru.socialnetwork4.dao.UserDAO;
import com.maru.socialnetwork4.model.User;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class UserService implements CustomService<User> {
    private final static UserDAO userDAO = new UserDAO();

    public User signIn(User user) {
        return userDAO.check(user);
    }

    @Override
    public User create(User user) {
        int userCount = userDAO.countUsernamesLike(user.getUsername());
        if (userCount > 0) {
            return null;
        }
        user.setDob("*chua dang ky");
        user.setfullName("*chua dang ky");
        user.setNote("*chua dang ky");
        return userDAO.add(user);
    }

    @Override
    public User update(User user) {
        return userDAO.update(user);
    }

    @Override
    public User delete(User user) {
        return null;
    }
}
