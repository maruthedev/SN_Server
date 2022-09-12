package com.maru.socialnetwork4.service;

import com.maru.socialnetwork4.model.User;
import com.maru.socialnetwork4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements CustomService<User>{
    @Autowired
    UserRepository userRepository;

    public User signIn(User user){
        return userRepository.checkUser(user.getUsername(), user.getPassword());
    }

    @Override
    public User create(User user) {
        if(userRepository.countUserByUsername(user.getUsername()) != 0) return null;
        return userRepository.add("*chua dang ky",
                "*chua dang ky",
               "*chua dang ky",
                user.getPassword(),
                user.getUsername());
    }

    @Override
    public User update(User user){
        return userRepository.modify(user.getDob(), user.getFullName(), user.getNote(), user.getPassword(), user.getUsername());
    }

    @Override
    public User delete(User user) {
        return null;
    }
}
