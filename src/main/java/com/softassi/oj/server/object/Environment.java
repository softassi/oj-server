package com.softassi.oj.server.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @ClassName : Envirment
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 15:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "envirment")
public class Environment {

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String type;
}
