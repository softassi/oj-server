package com.softassi.oj.server.service;

import com.softassi.oj.server.dto.CodeFileDto;
import com.softassi.oj.server.dto.CodeFileDto;
import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.object.CodeFile;
import com.softassi.oj.server.object.CodeFile;
import com.softassi.oj.server.repository.CodeFileRepository;
import com.softassi.oj.server.repository.CodeFileRepository;
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
public class CodeFileService {

    @Autowired
    private CodeFileRepository codeFileRepository;

    public CodeFile save(CodeFileDto codeFileDto) {

        CodeFile codeFile = CopyUtil.copy(codeFileDto, CodeFile.class);
        CodeFile result = codeFileRepository.save(codeFile);
        return result;
    }

    public CodeFile getById(String id) {
        Optional<CodeFile> CodeFile = codeFileRepository.findById(id);
        return CodeFile.orElse(null);
    }

    public List<CodeFile> list(PageDto pageDto) {
        PageRequest of = PageRequest.of(pageDto.getPage(), pageDto.getSize());
        Page<CodeFile> CodeFilePage = codeFileRepository.findAll(of);
        List<CodeFile> content = CodeFilePage.getContent();
        return content;
    }

    public void addCodeFile(CodeFile CodeFile) {
        CodeFile save = codeFileRepository.save(CodeFile);
    }

    public void submit(CodeFile CodeFile) {

    }

    public List<CodeFileDto> all() {
        List<CodeFile> all = codeFileRepository.findAll();
        List<CodeFileDto> CodeFileDtos = CopyUtil.copyList(all, CodeFileDto.class);
        return CodeFileDtos;
    }

    public void update(CodeFileDto CodeFileDto) {
        CodeFile copy = CopyUtil.copy(CodeFileDto, CodeFile.class);
        codeFileRepository.insert(copy);
    }

    public void delete(String id) {
        codeFileRepository.deleteById(id);
    }

}
