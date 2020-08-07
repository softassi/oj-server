package com.softassi.oj.server.controller.admin;

import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.object.Tag;
import com.softassi.oj.server.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(TagController.class);

    @Autowired
    private TagService tagService;

    @RequestMapping("/save")
    @ApiOperation("保存一个标签")
    public ResultBody save(String name) {
        tagService.save(name);
        return ResultBody.success();
    }

    @GetMapping(value = "/get")
    @ApiOperation("得到一个标签")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "name", value = "用户标签名")
    )
    public ResultBody get(String name) {
        LOG.info("你好");
        Tag tag = tagService.get();
        return ResultBody.success(tag);
    }

    @RequestMapping("/list")
    public ResultBody list() {
        LOG.info("list");
        return ResultBody.success();
    }
}
