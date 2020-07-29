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
 * @ClassName : CodeFile
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 15:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "codefile")
public class CodeFile {

    @Id
    private String id;

    @Field
    private String filename;

    @Field
    private String filehash;

    @Field
    private Long size;

    @Field("upload_time")
    @JsonProperty("upload_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime uploadTime = LocalDateTime.now();
}
