package com.softassi.oj.server.controller;

import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.dto.UserDto;
import com.softassi.oj.server.object.Test;
import com.softassi.oj.server.object.User;
import com.softassi.oj.server.repository.TestRepository;
import com.softassi.oj.server.service.UserService;
import com.softassi.oj.server.util.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName : UserController
 * @Description : 测试使用不必在意
 * @Author : cybersa
 * @Date: 2020-07-22 22:38
 */
@RestController
@Slf4j
@RequestMapping("/web/test")
public class TestController {

    @Autowired
    private TestRepository repository;

    @RequestMapping("/save")
    public ResultBody save(@RequestBody Test test) {
        System.out.println(test);
        test.setId(UUID.randomUUID().toString());
        repository.save(test);
        return ResultBody.success();
    }

    @GetMapping("/list")
    public ResultBody list() {
        List<Test> all = repository.findAll();
        return ResultBody.success(all);
    }

    @GetMapping("/all")
    public ResultBody all() {
        return ResultBody.success();
    }
}
