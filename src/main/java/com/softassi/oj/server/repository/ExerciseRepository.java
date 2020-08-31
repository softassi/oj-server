package com.softassi.oj.server.repository;

import com.softassi.oj.server.object.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ExerciseRepository extends MongoRepository<Exercise, String> {
    Exercise findByExerciseNo(Integer exerciseNo);

    Exercise findByTitleContaining(String title);

    List<Exercise> findAllByTagId(String tagId);
}