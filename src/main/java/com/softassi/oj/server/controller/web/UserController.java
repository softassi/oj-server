package com.softassi.oj.server.controller.web;

import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.dto.UserDto;
import com.softassi.oj.server.object.User;
import com.softassi.oj.server.service.UserService;
import com.softassi.oj.server.util.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.xml.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-22 22:38
 */
@RestController("webUserController")
@Slf4j
@RequestMapping("/web/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public ResultBody save(@RequestBody UserDto userDto) {
        UserDto save = userService.save(userDto);
        return ResultBody.success(save);
    }

    @GetMapping("/list")
    public ResultBody list(@RequestBody PageDto pageDto) {
        List<UserDto> list = userService.list(pageDto);
        return ResultBody.success(list);
    }

    @GetMapping("/all")
    public ResultBody all() {
        List<User> all = userService.all();
        return ResultBody.success(all);
    }

    @GetMapping("/get/{id}")
    public ResultBody get(@PathVariable("id") String id) {
        UserDto userDto = userService.get(id);
        return ResultBody.success(userDto);
    }

    @RequestMapping("/delete/{id}")
    public ResultBody delete(@PathVariable("id") String id) {
        log.info("删除用户id: {}", id);
        userService.delete(id);
        return ResultBody.success();
    }
    
    @RequestMapping("/update")
    public ResultBody update(@RequestBody UserDto userDto) {
        ValidatorUtils.require(userDto.getId(), "用户ID");
        log.info("update");
        userService.update(userDto);
        return ResultBody.success(userDto);
    }

    @RequestMapping("/reset")
    public ResultBody reset(@RequestBody UserDto userDto) {
        ValidatorUtils.require(userDto.getId(), "用户ID");
        ValidatorUtils.require(userDto.getPassword(), "用户密码");

        log.info("重置密码");

        UserDto reset = userService.reset(userDto);
        return ResultBody.success(reset);
    }
}
