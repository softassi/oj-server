package com.softassi.oj.server.controller;

import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.object.User;
import com.softassi.oj.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-22 22:38
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public ResultBody save() {
        User save = userService.save();
        return ResultBody.success(save);
    }

    @RequestMapping("/list")
    public ResultBody list() {
        List<User> list = userService.list();
        return ResultBody.success(list);
    }

    @RequestMapping("/get")
    public ResultBody get() {
        return ResultBody.success();
    }
}
