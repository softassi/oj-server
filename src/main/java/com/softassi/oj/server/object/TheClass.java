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
 * @ClassName : TheClass
 * @Description : 班级信息表
 * @Author : cybersa
 * @Date: 2020-07-23 15:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "theclass")
public class TheClass {

    @Id
    private String id;

    @Field(name = "class_name")
    private String className;

    @Field("class_size")
    private Long classSize;

    @Field("can_join_class")
    private String canJoinClass;

}
