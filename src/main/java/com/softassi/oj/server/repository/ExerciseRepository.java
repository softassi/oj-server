package com.softassi.oj.server.repository;

import com.softassi.oj.server.object.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ExerciseRepository extends MongoRepository<Exercise, String> {
    Exercise findByExerciseNo(Integer exerciseNo);

    Exercise findByTitleContaining(String title);
}