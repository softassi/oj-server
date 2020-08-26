package com.softassi.oj.server.service;

import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.TagDto;
import com.softassi.oj.server.object.Tag;
import com.softassi.oj.server.repository.TagRepository;
import com.softassi.oj.server.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @ClassName : TagService
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-24 11:15
 */
@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public void save(String name) {
        Tag tag = new Tag();
        tag.setName(name);
        tagRepository.save(tag);
    }

    public Tag get() {
        Tag tag = tagRepository.findByName("递归");
        System.out.println(tag.getTest().toString());
        DateTimeFormatter DATETIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse("2020-07-25 00:11:17", DATETIME);
        System.out.println(parse.getDayOfYear());
        return tag;
    }

    public List<TagDto> list(PageDto pageDto) {
        PageRequest of = PageRequest.of(pageDto.getPage(), pageDto.getSize());
        Page<Tag> tagPage = tagRepository.findAll(of);
        List<Tag> content = tagPage.getContent();
        return CopyUtil.copyList(content, TagDto.class);
    }
    public List<TagDto> all() {
        List<Tag> content = tagRepository.findAll();
        return CopyUtil.copyList(content, TagDto.class);
    }

    public TagDto update(TagDto tagDto) {
        Tag copy = CopyUtil.copy(tagDto, Tag.class);
        Tag save = tagRepository.save(copy);
        return CopyUtil.copy(save, TagDto.class);
    }

    public TagDto save(TagDto tagDto) {
        Tag copy = CopyUtil.copy(tagDto, Tag.class);
        Tag save = tagRepository.save(copy);
        return CopyUtil.copy(save, TagDto.class);
    }

    public void delete(String id) {
        tagRepository.deleteById(id);
    }
}
