package com.softassi.oj.server.controller.admin;

import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.dto.EnvironmentDto;
import com.softassi.oj.server.object.Environment;
import com.softassi.oj.server.object.User;
import com.softassi.oj.server.service.EnvironmentService;
import com.softassi.oj.server.service.UserService;
import com.softassi.oj.server.util.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-22 22:38
 */
@RestController(value = "adminEnvironmentController")
@Slf4j
@RequestMapping("/admin/environment")
public class EnvironmentController {

    @Autowired
    private EnvironmentService environmentService;

    @RequestMapping("/save")
    public ResultBody save(@RequestBody EnvironmentDto environmentDto) {
        ValidatorUtils.require(environmentDto.getId(), "环境ID");
        EnvironmentDto save = environmentService.save(environmentDto);
        return ResultBody.success(save);
    }

    @GetMapping("/all")
    public ResultBody all() {
        List<EnvironmentDto> all = environmentService.all();
        return ResultBody.success(all);
    }
    @GetMapping("/list")
    public ResultBody list(@RequestBody PageDto pageDto) {
        List<EnvironmentDto> list = environmentService.list(pageDto);
        return ResultBody.success(list);
    }

    @GetMapping("/get/{id}")
    public ResultBody get(@PathVariable("id") String id) {
        ValidatorUtils.require(id, "环境ID");

        Environment environment = environmentService.getById(id);
        return ResultBody.success(environment);
    }

    @RequestMapping("/delete/{id}")
    public ResultBody delete(@PathVariable("id") String id) {
        ValidatorUtils.require(id, "环境ID");

        environmentService.delete(id);
        return ResultBody.success();
    }


}
