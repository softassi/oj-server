package com.softassi.oj.server.service;

import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.PatternDto;
import com.softassi.oj.server.dto.TagDto;
import com.softassi.oj.server.enums.PatternExceptionEnum;
import com.softassi.oj.server.exception.OJException;
import com.softassi.oj.server.object.Pattern;
import com.softassi.oj.server.object.Tag;
import com.softassi.oj.server.repository.PatternRepository;
import com.softassi.oj.server.repository.TagRepository;
import com.softassi.oj.server.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.util.StringUtils;

/**
 * @ClassName : TagService
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-24 11:15
 */
@Service
public class PatternService {
    private static final Logger LOG = LoggerFactory.getLogger(PatternService.class);
    @Autowired
    private PatternRepository patternRepository;

    /**
     * 功能描述:
     * 保存一个Pattern
     * @Param: [patternDto]
     * @Return: com.softassi.oj.server.dto.PatternDto
     * @Author: a1725
     * @Date: 2020/8/19 20:46
     */
    public PatternDto save(PatternDto patternDto) {
        Pattern copy = CopyUtil.copy(patternDto, Pattern.class);
        Pattern save = patternRepository.save(copy);
        return CopyUtil.copy(save, PatternDto.class);
    }

    /**
     * 功能描述:
     * 根据id查找模式
     * @Param: [id]
     * @Return: com.softassi.oj.server.dto.PatternDto
     * @Author: a1725
     * @Date: 2020/8/19 20:36
     */
    public PatternDto get(String id) {
        Optional<Pattern> patternOptional = patternRepository.findById(id);
        if (patternOptional.isPresent()) {
            Pattern pattern = patternOptional.get();
            return CopyUtil.copy(pattern, PatternDto.class);
        }
        throw new OJException(PatternExceptionEnum.PATTERN_NO_EXIST);
    }

    public PatternDto getByName(String name) {
        Pattern pattern = patternRepository.findByName(name);
        return CopyUtil.copy(pattern, PatternDto.class);
    }

    public List<PatternDto> list(PageDto pageDto) {
        PageRequest of = PageRequest.of(pageDto.getPage(), pageDto.getSize());
        Page<Pattern> patternPage = patternRepository.findAll(of);
        List<Pattern> content = patternPage.getContent();
        return CopyUtil.copyList(content, PatternDto.class);
    }

    /**
     * 功能描述:
     * 获取所有的pattern
     * @Param: []
     * @Return: java.util.List<com.softassi.oj.server.dto.PatternDto>
     * @Author: a1725
     * @Date: 2020/8/19 20:37
     */
    public List<PatternDto> all() {
        List<Pattern> all = patternRepository.findAll();
        return CopyUtil.copyList(all, PatternDto.class);
    }

    /**
     * 功能描述:
     * 更新pattern
     * @Param: [patternDto]
     * @Return: com.softassi.oj.server.dto.PatternDto
     * @Author: a1725
     * @Date: 2020/8/19 20:37
     */
    public PatternDto update(PatternDto patternDto) {
        Pattern pattern = CopyUtil.copy(patternDto, Pattern.class);
        Pattern save = patternRepository.save(pattern);
        return CopyUtil.copy(save, PatternDto.class);
    }

    public void delete(String id) {
        patternRepository.deleteById(id);
    }

}
