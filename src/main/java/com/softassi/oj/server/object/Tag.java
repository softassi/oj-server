package com.softassi.oj.server.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Date;

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

    // @Field
    // private LocalDateTime test = LocalDateTime.now();

    // @Field
    // private Date test2 = new Date();
}
