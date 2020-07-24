package com.softassi.oj.server.repository;

import com.softassi.oj.server.object.CodeFile;
import com.softassi.oj.server.object.Environment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName : CodeFile
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 15:28
 */
public interface EnvironmentRepository extends MongoRepository<Environment, String> {
}
