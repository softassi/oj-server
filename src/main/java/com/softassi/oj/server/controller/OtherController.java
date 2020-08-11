package com.softassi.oj.server.controller;

import com.softassi.oj.server.dto.ResultBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName : OtherController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-27 21:05
 */
@RestController
public class OtherController {

    @RequestMapping("/upload")
    public ResultBody upload(@RequestParam("file") MultipartFile file) {

        System.out.println(file.getOriginalFilename());
        if (file.isEmpty()) {
            return ResultBody.error("file is empty");
        }
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        String filePath = "D:\\my-test\\";
        File file1 = new File(filePath);
        if (file1.exists()) {
            file1.mkdir();
        }

        String path = filePath + originalFilename;
        File dest = new File(path);
        
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultBody.error("upload fialure");
    }

    @RequestMapping("/batch")
    public ResultBody batch(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        for (MultipartFile file : files) {
            String filePath = "D:\\my-test\\";
            File dest = new File(filePath + file.getOriginalFilename());
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResultBody.success();
    }
}
