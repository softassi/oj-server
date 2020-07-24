package com.softassi.oj.server.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.softassi.oj.server.object.CodeFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

/**
 * @ClassName : CodeFile
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 15:28
 */
public interface CodeFileRepository extends MongoRepository<CodeFile, String> {
}
