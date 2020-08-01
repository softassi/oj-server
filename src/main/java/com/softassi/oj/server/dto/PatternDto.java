package com.softassi.oj.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName : Pattern
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 15:07
 */
public class PatternDto {

    private String id;

    private String name;

    // 可选环境变量
    private List<EnvironmentDto> environments;

    @JsonProperty("max_memory")
    private double maxMemoey;

    @JsonProperty("max_cpu")
    private double maxCpu;

    private String intro;

    private List<String> tags;

    @JsonProperty("submit_name")
    private String submitName;

    @JsonProperty("submit_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime submitTime = LocalDateTime.now();

    @JsonProperty("use_count")
    private Long useCount;

    @JsonProperty("last_use_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUseTime = LocalDateTime.now();
}

