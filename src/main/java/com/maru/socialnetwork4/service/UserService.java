package com.maru.socialnetwork4.service;

import com.maru.socialnetwork4.model.User;
import com.maru.socialnetwork4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService implements CustomService<User>{
    @Autowired
    UserRepository userRepository;
    // private UserDAO userDAO = new UserDAO();

    public User signIn(User user){
        return userRepository.checkUser(user.getUsername(), user.getPassword());
        // return userDAO.check(user);
    }

    @Override
    public User create(User user) {
        if(userRepository.countUserByUsername(user.getUsername()) != 0) return null;
        userRepository.add("*chua dang ky",
                "*chua dang ky",
               "*chua dang ky",
                user.getPassword(),
                user.getUsername());
        user.setDob("*chua dang ky");
        user.setfullName("*chua dang ky");
        user.setNote("*chua dang ky");
        return user;
        // return userDAO.add(user);
    }

    @Override
    public User update(User user){
        userRepository.modify(user.getDob(), user.getfullName(), user.getNote(), user.getPassword(), user.getUsername());
        return user;
        //return userDAO.update(user);
    }

    @Override
    public User delete(User user) {
        return null;
    }
}
