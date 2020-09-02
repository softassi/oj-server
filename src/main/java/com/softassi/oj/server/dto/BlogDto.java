package com.softassi.oj.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.security.SecureRandom;
import java.time.LocalDateTime;

/**
 * @ClassName : Blog
 * @Description : 博客信息
 * @Author : cybersa
 * @Date: 2020-08-24 23:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto implements Serializable {

    private String id;

    private String title;

    private String content;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("release_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime releaseTime = LocalDateTime.now();

    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime = LocalDateTime.now();
}
