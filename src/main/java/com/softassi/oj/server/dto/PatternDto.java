package com.softassi.oj.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName : Pattern
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 15:07
 */
public class PatternDto implements Serializable {

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PatternDto{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", environments=").append(environments);
        sb.append(", maxMemoey=").append(maxMemoey);
        sb.append(", maxCpu=").append(maxCpu);
        sb.append(", intro='").append(intro).append('\'');
        sb.append(", tags=").append(tags);
        sb.append(", submitName='").append(submitName).append('\'');
        sb.append(", submitTime=").append(submitTime);
        sb.append(", useCount=").append(useCount);
        sb.append(", lastUseTime=").append(lastUseTime);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EnvironmentDto> getEnvironments() {
        return environments;
    }

    public void setEnvironments(List<EnvironmentDto> environments) {
        this.environments = environments;
    }

    public double getMaxMemoey() {
        return maxMemoey;
    }

    public void setMaxMemoey(double maxMemoey) {
        this.maxMemoey = maxMemoey;
    }

    public double getMaxCpu() {
        return maxCpu;
    }

    public void setMaxCpu(double maxCpu) {
        this.maxCpu = maxCpu;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getSubmitName() {
        return submitName;
    }

    public void setSubmitName(String submitName) {
        this.submitName = submitName;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }

    public Long getUseCount() {
        return useCount;
    }

    public void setUseCount(Long useCount) {
        this.useCount = useCount;
    }

    public LocalDateTime getLastUseTime() {
        return lastUseTime;
    }

    public void setLastUseTime(LocalDateTime lastUseTime) {
        this.lastUseTime = lastUseTime;
    }

    @JsonProperty("last_use_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUseTime = LocalDateTime.now();
}

