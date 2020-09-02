package com.softassi.oj.server.object;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Blog
 * @Description : 博客信息
 * @Author : cybersa
 * @Date: 2020-08-24 23:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "test")
public class Test {

    @Id
    private String id;

    @Field
    private String title;

    @Field
    private String content;

    @Field
    private List<String> a = new ArrayList<>();

    @Field
    private List<Tag> tags = new ArrayList<>();

}