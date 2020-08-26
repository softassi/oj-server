package com.softassi.oj.server.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @ClassName : ClassUser
 * @Description :班级学生关联表
 * @Author : cybersa
 * @Date: 2020-07-23 15:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "class_user")
public class ClassUser {

    @Id
    private String id;

    @Field(name = "class_id")
    private String classId;

    @Field("user_id")
    private String userId;



}
