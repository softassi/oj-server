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
 * @ClassName : Tag
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 15:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tag")
public class Tag {

    @Id
    private String id;

    @Field
    private String name;

    @Field("create_time")
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime = LocalDateTime.now();

    @Field("update_time")
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime = LocalDateTime.now();

}
