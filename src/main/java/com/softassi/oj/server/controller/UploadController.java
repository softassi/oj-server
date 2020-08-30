package com.softassi.oj.server.controller;

import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.util.MinioUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @ClassName : OtherController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-27 21:05
 */
@RestController
public class UploadController {

    @Value("${minio.bucket}")
    private String bucket;

    @PostMapping("/upload")
    public ResultBody upload(@RequestParam("file") MultipartFile file) {
        try {
            InputStream is = file.getInputStream(); //得到文件流
            String fileName = file.getOriginalFilename(); //文件名
            String contentType = file.getContentType();  //类型
            System.out.println(bucket);
            MinioUtils.putObject(bucket, fileName, is, file.getSize());
            String remoteUrl = MinioUtils.getObjectUrl(bucket, fileName);
            return ResultBody.success(remoteUrl);
        } catch (Exception e) {
            return ResultBody.error("上传失败");
        }
    }

    @GetMapping("/download")
    public ResultBody download(String url, HttpServletResponse response) {
        try {
            String fileName = url.substring(url.lastIndexOf("/") + 1);
            System.out.println("文件名为" + fileName);
            InputStream fileInputStream = MinioUtils.getObject(bucket, fileName);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/force-download");
            response.setCharacterEncoding("UTF-8");
            IOUtils.copy(fileInputStream, response.getOutputStream());
            return ResultBody.success();
        }
        catch (Exception e) {
            return ResultBody.error("下载失败");
        }
    }
}
