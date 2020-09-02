package com.softassi.oj.server.repository;


import com.softassi.oj.server.object.Blog;
import com.softassi.oj.server.object.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TestRepository extends MongoRepository<Test, String> {

}
