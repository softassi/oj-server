package com.softassi.oj.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * @ClassName : CodeFile
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 15:28
 */
public class CodeFileDto {

    private String id;

    private String filename;

    private String filehash;

    private Long size;

    @JsonProperty("upload_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime uploadTime = LocalDateTime.now();
}
