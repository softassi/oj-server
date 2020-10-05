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
 * @ClassName : ExerciseSource
 * @Description : 题目来源(不一定有用)
 * @Author : cybersa
 * @Date: 2020-08-24 23:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "exercise_source")
public class ExerciseSource {

    @Id
    private String id;

    @Field("source_name")
    @JsonProperty("source_name")
    private String sourceName;

    @Field
    private String url;
}
