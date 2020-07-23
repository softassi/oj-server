package com.softassi.oj.server.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * @ClassName : Pattern
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 15:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pattern")
public class Pattern {

    @Id
    private Integer id;

    @Field
    private String name;

    // 可选环境变量
    @Field
    private List<Environment> environments;

    @Field("max_memory")
    @JsonProperty("max_memory")
    private double maxMemoey;

    @Field("max_cpu")
    @JsonProperty("max_cpu")
    private double maxCpu;

    @Field
    private String intro;

    @Field
    private List<String> tags;

    @Field("submit_name")
    @JsonProperty("submit_name")
    private String submitName;

    @Field("submit_time")
    @JsonProperty("submit_time")
    private Date submitTime = new Date();

    @Field("use_count")
    @JsonProperty("use_count")
    private Long useCount;

    @Field("last_use_time")
    @JsonProperty("last_use_time")
    private Date lastUseTime = new Date();

}

