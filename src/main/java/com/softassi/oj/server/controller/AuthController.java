package com.softassi.oj.server.controller;

import com.softassi.oj.server.dto.CreateUser;
import com.softassi.oj.server.dto.FixUser;
import com.softassi.oj.server.error.BizException;
import com.softassi.oj.server.object.User;
import com.softassi.oj.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/id")
    public User getUser(String id){
        return userRepository.findUserById(id);
    }

    @GetMapping("/name")
    public User getUserByName(String name){
        return userRepository.findUserByName(name);
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PutMapping("/create")
    public User createUser(@RequestBody CreateUser user){
        // return userRepository.save(new User(null,user.getName(),user.getCreateTime()));
        return new User();
    }

    @PostMapping("/fix")
    public User fixUser(@RequestBody FixUser user){
        User user1 = userRepository.findUserByName(user.getName());
        user1.setCreateTime(LocalDateTime.now());
        return userRepository.save(user1);
    }

    @GetMapping("/random")
    public User randomUser(){
        throw new BizException();
    }
}
