package com.softassi.oj.server.repository;

import com.softassi.oj.server.object.Exercise;
import com.softassi.oj.server.object.Pattern;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PatternRepository extends MongoRepository<Pattern, String> {
    Pattern findByName(String name);
}