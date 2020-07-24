package com.softassi.oj.server.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String password;

    @Field("create_time")
    @JsonProperty(value = "create_time")
    private LocalDateTime createTime = LocalDateTime.now();

    @Field("update_time")
    @JsonProperty("update_time")
    private LocalDateTime updateTime = LocalDateTime.now();

    @Field
    private String github;

    @Field
    private String email;

    @Field
    private String group;

    public User(String name) {
        this.name = name;
    }
}
