package com.softassi.oj.server.service;

import com.softassi.oj.server.dto.EnvironmentDto;
import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.object.Environment;
import com.softassi.oj.server.repository.EnvironmentRepository;
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
public class EnvironmentService {

    @Autowired
    private EnvironmentRepository environmentRepository;

    public EnvironmentDto save(EnvironmentDto environmentDto) {

        Environment environment = CopyUtil.copy(environmentDto, Environment.class);
        Environment result = environmentRepository.save(environment);
        return CopyUtil.copy(result, EnvironmentDto.class);
    }

    public Environment getById(String id) {
        Optional<Environment> Environment = environmentRepository.findById(id);
        return Environment.orElse(null);
    }

    public List<EnvironmentDto> list(PageDto pageDto) {
        PageRequest of = PageRequest.of(pageDto.getPage(), pageDto.getSize());
        Page<Environment> environmentPage = environmentRepository.findAll(of);
        List<Environment> content = environmentPage.getContent();
        List<EnvironmentDto> environmentDtos = CopyUtil.copyList(content, EnvironmentDto.class);
        return environmentDtos;
    }

    public void addEnvironment(Environment Environment) {
        Environment save = environmentRepository.save(Environment);
    }


    public List<EnvironmentDto> all() {
        List<Environment> all = environmentRepository.findAll();
        List<EnvironmentDto> EnvironmentDtos = CopyUtil.copyList(all, EnvironmentDto.class);
        return EnvironmentDtos;
    }

    public void update(EnvironmentDto EnvironmentDto) {
        Environment copy = CopyUtil.copy(EnvironmentDto, Environment.class);
        environmentRepository.insert(copy);
    }

    public void delete(String id) {
        environmentRepository.deleteById(id);
    }

}
