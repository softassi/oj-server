package com.softassi.oj.server.controller.admin;

import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.PatternDto;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.dto.TagDto;
import com.softassi.oj.server.object.Tag;
import com.softassi.oj.server.service.PatternService;
import com.softassi.oj.server.service.TagService;
import com.softassi.oj.server.util.ValidatorUtils;
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
@RestController("adminPatternController")
@Api(tags = "标签管理接口")
@RequestMapping("/admin/pattern")
public class PatternController {
    private static final Logger LOG = LoggerFactory.getLogger(PatternController.class);

    @Autowired
    private PatternService patternService;

    @RequestMapping("/save")
    @ApiOperation("保存一个模式")
    public ResultBody save(@RequestBody PatternDto patternDto) {
        ValidatorUtils.require(patternDto.getId(), "模式ID");

        PatternDto save = patternService.save(patternDto);
        return ResultBody.success(save);
    }

    @GetMapping(value = "/get")
    @ApiOperation("得到一个模式")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "name", value = "用户标签名")
    )
    public ResultBody get(String name) {
        ValidatorUtils.require(name, "用户名");
        PatternDto patternDto = patternService.getByName(name);
        return ResultBody.success(patternDto);
    }

    @GetMapping("/get/{id}")
    public ResultBody getById(@PathVariable String id) {
        ValidatorUtils.require(id, "模式ID");
        PatternDto patternDto = patternService.get(id);
        return ResultBody.success(patternDto);
    }
    @GetMapping("/list")
    public ResultBody list(@RequestBody PageDto pageDto) {
        LOG.info("page:{}, size:{}", pageDto.getPage(), pageDto.getSize());
        List<PatternDto> list = patternService.list(pageDto);
        return ResultBody.success(list);
    }

    @GetMapping("/all")
    public ResultBody all() {
        List<PatternDto> list = patternService.all();
        return ResultBody.success(list);
    }

    @PostMapping("/update")
    public ResultBody update(@RequestBody PatternDto patternDto) {
        ValidatorUtils.require(patternDto.getId(), "模式ID");

        PatternDto update = patternService.update(patternDto);
        return ResultBody.success(update);
    }

    @RequestMapping("/delete/{id}")
    public ResultBody delete(@PathVariable("id") String id) {
        ValidatorUtils.require(id, "模式ID");
        patternService.delete(id);
        return ResultBody.success();
    }
}
