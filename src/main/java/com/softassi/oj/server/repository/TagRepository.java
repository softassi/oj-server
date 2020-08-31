package com.softassi.oj.server.repository;

import com.softassi.oj.server.object.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TagRepository extends MongoRepository<Tag, String> {
    Tag findByName(String name);
    List<Tag> findAllById(String id);
}