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
import java.util.List;

/**
 * @ClassName : Exercise
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 14:50
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "exercise")
public class Exercise {

    @Id
    private String id;

    @Field("exercise_no")
    private Integer exerciseNo;
    
    @Field
    private String title;

    @Field
    private String desc;

    @Field("max_time")
    @JsonProperty("max_time")
    private double maxTime;

    @Field("max_cpu")
    @JsonProperty("max_cpu")
    private double maxCpu;

    @Field("max_memory")
    @JsonProperty("max_memory")
    private double maxMemory;

    @Field("question_setter")
    @JsonProperty("question_setter")
    private String questionSetter;

    @Field("question_time")
    @JsonProperty("question_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime questionTime = LocalDateTime.now();

    @Field("pass_rate")
    @JsonProperty("pass_rate")
    private double passRate;

    @Field("tag_id")
    @JsonProperty("tag_id")
    private String tagId;

    // 五阶段使用的模式
    @Field
    private List<Pattern> patterns;

}
