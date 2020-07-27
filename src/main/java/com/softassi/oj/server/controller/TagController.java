package com.softassi.oj.server.controller;

import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : TagController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-24 11:17
 */
@RestController
@Api(tags = "标签管理接口")
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/save")
    @ApiOperation("保存一个标签")
    public ResultBody save() {
        tagService.save();
        return ResultBody.success();
    }

    @GetMapping(value = "/get")
    @ApiOperation("得到一个标签")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "name", value = "用户标签名")
    )
    public ResultBody get(String name) {
        System.out.println("你好");
        tagService.get();
        return ResultBody.success();
    }
}
