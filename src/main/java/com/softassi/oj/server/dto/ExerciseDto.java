package com.softassi.oj.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName : Exercise
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 14:50
 */

public class ExerciseDto implements Serializable {

    private String id;

    @JsonProperty("exercise_no")
    private Integer exerciseNo;

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

    @JsonProperty("tag_id")
    private String tagId;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ExerciseDto{");
        sb.append("id='").append(id).append('\'');
        sb.append(", exerciseNo=").append(exerciseNo);
        sb.append(", title='").append(title).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append(", maxTime=").append(maxTime);
        sb.append(", maxCpu=").append(maxCpu);
        sb.append(", maxMemory=").append(maxMemory);
        sb.append(", questionSetter='").append(questionSetter).append('\'');
        sb.append(", tagId='").append(tagId).append('\'');
        sb.append(", questionTime=").append(questionTime);
        sb.append(", passRate=").append(passRate);
        sb.append(", patterns=").append(patterns);
        sb.append('}');
        return sb.toString();
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public Integer getExerciseNo() {
        return exerciseNo;
    }

    public void setExerciseNo(Integer exerciseNo) {
        this.exerciseNo = exerciseNo;
    }

    @JsonProperty("question_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime questionTime = LocalDateTime.now();

    @JsonProperty("pass_rate")
    private double passRate;

    // 五阶段使用的模式
    private List<PatternDto> patterns;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(double maxTime) {
        this.maxTime = maxTime;
    }

    public double getMaxCpu() {
        return maxCpu;
    }

    public void setMaxCpu(double maxCpu) {
        this.maxCpu = maxCpu;
    }

    public double getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(double maxMemory) {
        this.maxMemory = maxMemory;
    }

    public String getQuestionSetter() {
        return questionSetter;
    }

    public void setQuestionSetter(String questionSetter) {
        this.questionSetter = questionSetter;
    }

    public LocalDateTime getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(LocalDateTime questionTime) {
        this.questionTime = questionTime;
    }

    public double getPassRate() {
        return passRate;
    }

    public void setPassRate(double passRate) {
        this.passRate = passRate;
    }

    public List<PatternDto> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<PatternDto> patterns) {
        this.patterns = patterns;
    }
}
