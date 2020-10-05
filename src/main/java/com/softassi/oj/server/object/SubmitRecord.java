package com.softassi.oj.server.object;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.lang.annotation.Documented;
import java.time.LocalDateTime;

/**
 * @ClassName : SubmitRecord
 * @Description : 提交记录
 * @Author : cybersa
 * @Date: 2020-10-05 23:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("submit_record")
public class SubmitRecord {

    @Id
    private String id;

    @Field("user_id")
    @JsonProperty("user_id")
    private String userId;

    @Field("exercise_id")
    @JsonProperty("exercise_id")
    private String exerciseId;


    @Field("submit_time")
    @JsonProperty("submit_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime submitIme = LocalDateTime.now();

    @Field
    private String status;

    @Field
    private Double runtime;

    @Field
    private String language;

    @Field("pattern_id")
    private String patternId;
}
