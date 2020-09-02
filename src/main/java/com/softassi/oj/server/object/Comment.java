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

/**
 * @ClassName : Comment
 * @Description : 题目的评论,暂时没有设计楼中楼
 * @Author : cybersa
 * @Date: 2020-08-24 23:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comment")
public class Comment {

    @Id
    private String id;

    @Field
    private String content;

    @Field("exercise_id")
    @JsonProperty("exercise_id")
    private String exerciseId;


    @Field("user_id")
    @JsonProperty("user_id")
    private String userId;

    @Field("release_time")
    @JsonProperty("release_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime releaseTime = LocalDateTime.now();

}
