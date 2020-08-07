package com.softassi.oj.server.controller.admin;

import com.softassi.oj.server.dto.ResultBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : TagController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-24 11:17
 */
@RestController
@Api(tags = "题目管理接口")
@RequestMapping("/exercise")
public class ExerciseController {

    @RequestMapping("/save")
    @ApiOperation("保存一个标签")
    public ResultBody save() {
        return ResultBody.success();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation("得到一个标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "题目id", paramType = "path")
    })
    public ResultBody get(@PathVariable("id") String id) {
        return ResultBody.success();
    }
}
