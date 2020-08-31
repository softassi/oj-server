package com.softassi.oj.server.controller.admin;

import com.softassi.oj.server.dto.BlogDto;
import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.dto.BlogDto;
import com.softassi.oj.server.object.Blog;
import com.softassi.oj.server.service.BlogService;
import com.softassi.oj.server.service.BlogService;
import com.softassi.oj.server.util.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.ApiListing;

import javax.xml.transform.Result;
import java.util.List;

/**
 * @ClassName : BlogController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-22 22:38
 */
@RestController(value = "adminBlogController")
@RequestMapping("/admin/blog")
@Slf4j
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/save")
    public ResultBody save(@RequestBody BlogDto blogDto) {
        BlogDto save = blogService.save(blogDto);
        return ResultBody.success(save);
    }

    @RequestMapping("/all")
    public ResultBody all() {
        List<BlogDto> Blogs = blogService.all();
        return ResultBody.success(Blogs);
    }
    @RequestMapping("/list")
    public ResultBody list(@RequestBody PageDto pageDto) {
        List<BlogDto> list = blogService.list(pageDto);
        return ResultBody.success(list);
    }

    @RequestMapping("/get/{id}")
    public ResultBody get(@PathVariable("id") String id) {
        BlogDto blogDto = blogService.get(id);
        return ResultBody.success(blogDto);
    }

    @RequestMapping("/delete/{id}")
    public ResultBody delete(@PathVariable("id") String id) {
        ValidatorUtils.require(id, "博客ID");
        blogService.delete(id);
        return ResultBody.success();
    }

    @RequestMapping("/update")
    public ResultBody update(@RequestBody BlogDto blogDto) {
        ValidatorUtils.require(blogDto.getId(), "博客ID");

        BlogDto update = blogService.update(blogDto);
        return ResultBody.success(update);
    }

    @RequestMapping("/list-by-title/{title}")
    public ResultBody listByTitle(@PathVariable("title") String title) {
        blogService.listByTitle(title);
        return ResultBody.success();
    }
}
