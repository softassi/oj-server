package com.softassi.oj.server.controller;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.softassi.oj.server.dto.CreateUser;
import com.softassi.oj.server.dto.FixUser;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.exception.BizException;
import com.softassi.oj.server.object.User;
import com.softassi.oj.server.repository.UserRepository;
import com.softassi.oj.server.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/auth")
@Slf4j
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
    public List<User> getusers(){
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

    @RequestMapping("/verify")
    public ResultBody verify(String token) {
        log.info("token: {}", token);
        try {
            JWTUtils.verify(token);
            DecodedJWT tokenInfo = JWTUtils.getTokenInfo(token);
            String id = tokenInfo.getClaim("id").asString();
            String name = tokenInfo.getClaim("name").asString();
            return ResultBody.success(name);
        }
        catch (SignatureVerificationException e) {
            e.printStackTrace();
            return ResultBody.error("无效签名");
        }
        catch (TokenExpiredException e) {
            e.printStackTrace();
            return ResultBody.error("token过期");
        }
        catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            return ResultBody.error("算法不匹配");
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultBody.error("异常");
        }
    }
}
