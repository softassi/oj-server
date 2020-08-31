package com.softassi.oj.server.controller.admin;

import com.softassi.oj.server.dto.ExerciseDto;
import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.object.Exercise;
import com.softassi.oj.server.service.ExerciseService;
import com.softassi.oj.server.util.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

/**
 * @ClassName : TagController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-24 11:17
 */
@RestController("adminExerciseController")
@Api(tags = "题目管理接口")
@RequestMapping("/admin/exercise")
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

    @GetMapping(value = "/get/{no}")
    @ApiOperation("通过题号得到一个习题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "题目id", paramType = "path")
    })
    public ResultBody get(@PathVariable("no") Integer no) {
        ExerciseDto exerciseDto = exerciseService.getByNo(no);
        if (exerciseDto == null) {
            ResultBody.error("没有改习题");
        }
        return ResultBody.success(exerciseDto);
    }

    @GetMapping(value = "/getByTitle")
    @ApiOperation("通过题号得到一个习题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "题目id", paramType = "path")
    })
    public ResultBody getByTitle(String title) {
        ExerciseDto exerciseDto = exerciseService.getByTitle(title);
        if (exerciseDto == null) {
            ResultBody.error("没有改习题");
        }
        return ResultBody.success(exerciseDto);
    }


    @GetMapping("/list")
    public ResultBody list(@RequestBody PageDto pageDto) {
        LOG.info("page:{}, size:{}", pageDto.getPage(), pageDto.getSize());
        List<Exercise> list = exerciseService.list(pageDto);
        return ResultBody.success(list);
    }

    @GetMapping("/all")
    @ApiOperation("得到全部的习题")
    public ResultBody all() {
        List<ExerciseDto> list = exerciseService.all();
        return ResultBody.success(list);
    }

    @PostMapping("/update")
    public ResultBody update(@RequestBody ExerciseDto exerciseDto) {
        exerciseService.update(exerciseDto);
        return ResultBody.success();
    }

    @RequestMapping("/delete/{id}")
    public ResultBody delete(@PathVariable("id") String id) {
        exerciseService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/list-by-tag/{tagId}")
    public ResultBody listByTag(@PathVariable("tagId") String tagId) {
        ValidatorUtils.require(tagId, "标签ID");

        LOG.info("list-by-tag:{}", tagId);
        List<ExerciseDto> exerciseDtos = exerciseService.listByTag(tagId);
        return ResultBody.success(exerciseDtos);
    }

    @PostMapping("update-tag")
    public ResultBody updateTag(@RequestBody ExerciseDto exerciseDto) {
        ValidatorUtils.require(exerciseDto.getId(), "习题ID");
        ValidatorUtils.require(exerciseDto.getTagId(), "习题标签ID");

        exerciseService.updateTag(exerciseDto);
        return ResultBody.success();
    }
}


