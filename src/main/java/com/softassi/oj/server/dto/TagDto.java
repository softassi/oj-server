package com.softassi.oj.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @ClassName : Tag
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 15:36
 */

public class TagDto {

    private String id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime test = LocalDateTime.now();

}
