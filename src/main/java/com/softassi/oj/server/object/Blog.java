package com.softassi.oj.server.object;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.framework.qual.FromStubFile;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
@Document(collection = "blog")
public class Blog {

    @Id
    private String id;

    @Field
    private String title;

    @Field
    private String content;

    @Field("user_id")
    private String userId;

    @Field("release_time")
    @JsonProperty("release_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime releaseTime = LocalDateTime.now();

    @Field("update_time")
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime = LocalDateTime.now();
}
