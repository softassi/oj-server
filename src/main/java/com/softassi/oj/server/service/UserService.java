package com.softassi.oj.server.service;

import com.softassi.oj.server.object.User;
import com.softassi.oj.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : UserService
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-22 22:37
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save() {
        User user = new User("cy");
        userRepository.save(user);
        return user;
    }

    public List<User> list() {
        return userRepository.findAll();
    }
}
