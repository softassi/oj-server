package com.softassi.oj.server.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
    private Integer id;

    @Field
    private String name;

}
