package com.softassi.oj.server.repository;

import com.softassi.oj.server.object.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserById(String id);

    User findUserByName(String name);
}