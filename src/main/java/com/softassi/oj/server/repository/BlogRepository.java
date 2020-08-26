package com.softassi.oj.server.repository;


import com.softassi.oj.server.object.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, String> {

}
