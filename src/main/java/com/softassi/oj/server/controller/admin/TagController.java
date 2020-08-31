package com.softassi.oj.server.controller.admin;

import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.dto.TagDto;
import com.softassi.oj.server.object.Tag;
import com.softassi.oj.server.service.TagService;
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
@RestController("adminTagController")
@Api(tags = "标签管理接口")
@RequestMapping("/admin/tag")
public class TagController {
    private static final Logger LOG = LoggerFactory.getLogger(TagController.class);

    @Autowired
    private TagService tagService;

    @RequestMapping("/save")
    @ApiOperation("保存一个标签")
    public ResultBody save(@RequestBody TagDto tagDto) {
        TagDto save = tagService.save(tagDto);
        return ResultBody.success(save);
    }

    @GetMapping(value = "/get")
    @ApiOperation("得到一个标签")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "name", value = "用户标签名")
    )
    public ResultBody get(String name) {
        LOG.info("get()");
        Tag tag = tagService.get();
        return ResultBody.success(tag);
    }

    @GetMapping("/list")
    public ResultBody list(@RequestBody PageDto pageDto) {
        LOG.info("page:{}, size:{}", pageDto.getPage(), pageDto.getSize());
        List<TagDto> list = tagService.list(pageDto);
        return ResultBody.success(list);
    }

    @GetMapping("/all")
    public ResultBody all() {
        List<TagDto> list = tagService.all();
        return ResultBody.success(list);
    }



    @PostMapping("/update")
    public ResultBody update(@RequestBody TagDto tagDto) {
        TagDto update = tagService.update(tagDto);
        return ResultBody.success(update);
    }
}
