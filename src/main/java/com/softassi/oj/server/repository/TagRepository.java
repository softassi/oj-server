package com.softassi.oj.server.repository;

import com.softassi.oj.server.object.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;


public interface TagRepository extends MongoRepository<Tag, String> {
    Tag findByName(String name);
}