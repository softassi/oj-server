package com.softassi.oj.server.controller;

import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : TagController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-24 11:17
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("save")
    public ResultBody save() {
        tagService.save();
        return ResultBody.success();
    }
}