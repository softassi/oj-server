package com.softassi.oj.server.service;

import com.softassi.oj.server.object.Tag;
import com.softassi.oj.server.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public void save() {
        Tag tag = new Tag();
        tag.setName("递归");
        tagRepository.save(tag);
    }
}
