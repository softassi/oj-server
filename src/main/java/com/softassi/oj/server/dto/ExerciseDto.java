package com.softassi.oj.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName : Exercise
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 14:50
 */

public class ExerciseDto {

    private String id;

    private String title;

    private String desc;

    @JsonProperty("max_time")
    private double maxTime;

    @JsonProperty("max_cpu")
    private double maxCpu;

    @JsonProperty("max_memory")
    private double maxMemory;

    @JsonProperty("question_setter")
    private String questionSetter;

    @JsonProperty("question_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime questionTime = LocalDateTime.now();

    @JsonProperty("pass_rate")
    private double passRate;

    // 五阶段使用的模式
    private List<PatternDto> patterns;
}
