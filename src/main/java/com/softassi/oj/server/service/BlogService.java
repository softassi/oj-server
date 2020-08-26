package com.softassi.oj.server.service;

import com.softassi.oj.server.dto.BlogDto;
import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.object.Blog;
import com.softassi.oj.server.repository.BlogRepository;
import com.softassi.oj.server.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName : ExerviseService
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-27 20:58
 */
@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public BlogDto save(BlogDto BlogDto) {

        Blog Blog = CopyUtil.copy(BlogDto, Blog.class);
        Blog result = blogRepository.save(Blog);
        return CopyUtil.copy(result, BlogDto.class);
    }

    public BlogDto get(String id) {
        Optional<Blog> Blog = blogRepository.findById(id);
        Blog blog = Blog.orElse(null);
        return CopyUtil.copy(blog, BlogDto.class);
    }

    public List<BlogDto> list(PageDto pageDto) {
        PageRequest of = PageRequest.of(pageDto.getPage(), pageDto.getSize());
        Page<Blog> BlogPage = blogRepository.findAll(of);
        List<Blog> content = BlogPage.getContent();
        return CopyUtil.copyList(content, BlogDto.class);
    }

    public void addBlog(Blog Blog) {
        Blog save = blogRepository.save(Blog);
    }

    public List<BlogDto> all() {
        List<Blog> all = blogRepository.findAll();
        List<BlogDto> BlogDtos = CopyUtil.copyList(all, BlogDto.class);
        return BlogDtos;
    }

    public void update(BlogDto BlogDto) {
        Blog copy = CopyUtil.copy(BlogDto, Blog.class);
        blogRepository.insert(copy);
    }

    public void delete(String id) {
        blogRepository.deleteById(id);
    }

}
