package com.maru.socialnetwork4.Service;

import com.maru.socialnetwork4.Dao.UserDAO;
import com.maru.socialnetwork4.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements CustomService<User>, UserDetailsService {
    private final static UserDAO userDAO = new UserDAO();

    public User signIn(User user) {
        return userDAO.check(user);
    }

    @Override
    public User create(User user) {
        return userDAO.create(user);
    }

    @Override
    public User update(User user) {
        return userDAO.update(user);
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.loadUserByUsername(username);
    }

    public User loadUserById(int id){
        return userDAO.loadUserById(id);
    }
}
