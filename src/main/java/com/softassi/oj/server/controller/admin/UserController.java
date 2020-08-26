package com.softassi.oj.server.controller.admin;

import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.dto.UserDto;
import com.softassi.oj.server.object.User;
import com.softassi.oj.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-22 22:38
 */
@RestController(value = "adminUserController")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public ResultBody save(@RequestBody UserDto userDto) {
        UserDto save = userService.save(userDto);
        return ResultBody.success(save);
    }

    @RequestMapping("/all")
    public ResultBody all() {
        List<User> users = userService.all();
        return ResultBody.success(users);
    }
    @RequestMapping("/list")
    public ResultBody list(@RequestBody PageDto pageDto) {
        List<UserDto> list = userService.list(pageDto);
        return ResultBody.success(list);
    }

    @RequestMapping("/get")
    public ResultBody get() {
        log.info("");
        return ResultBody.success();
    }

    @RequestMapping("/delete/{id}")
    public ResultBody delete(@PathVariable("id") String id) {
        userService.delete(id);
        return ResultBody.success();
    }
}
