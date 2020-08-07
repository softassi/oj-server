package com.softassi.oj.server.controller.admin;

import com.softassi.oj.server.dto.ExerciseDto;
import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.object.Exercise;
import com.softassi.oj.server.service.ExerciseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private static final Logger LOG = LoggerFactory.getLogger(ExerciseController.class);

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping("/save")
    @ApiOperation("添加一个习题")
    public ResultBody save(@RequestBody ExerciseDto exerciseDto) {
        Exercise save = exerciseService.save(exerciseDto);
        return ResultBody.success(save);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation("得到一个习题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "题目id", paramType = "path")
    })
    public ResultBody get(@PathVariable("id") String id) {
        return ResultBody.success();
    }

    @GetMapping("/list")
    public ResultBody list(@RequestBody PageDto pageDto) {
        LOG.info("page:{}, size:{}", pageDto.getPage(), pageDto.getSize());
        List<Exercise> list = exerciseService.list(pageDto);
        return ResultBody.success(list);
    }
    

}

