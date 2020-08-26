package com.softassi.oj.server.service;

import com.softassi.oj.server.dto.ExerciseDto;
import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.object.Exercise;
import com.softassi.oj.server.repository.ExerciseRepository;
import com.softassi.oj.server.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName : ExerviseService
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-27 20:58
 */
@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public Exercise save(ExerciseDto exerciseDto) {
        // todo 应该要自动计算题号
        Exercise copy = CopyUtil.copy(exerciseDto, Exercise.class);
        Exercise result = exerciseRepository.save(copy);
        return result;
    }

    public Exercise getById(String id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        return exercise.orElse(null);
    }

    public List<Exercise> list(PageDto pageDto) {
        PageRequest of = PageRequest.of(pageDto.getPage(), pageDto.getSize());
        Page<Exercise> exercisePage = exerciseRepository.findAll(of);
        List<Exercise> content = exercisePage.getContent();
        return content;
    }

    public void addExercise(Exercise exercise) {
        Exercise save = exerciseRepository.save(exercise);
    }

    public void submit(Exercise exercise) {

    }

    public List<ExerciseDto> all() {
        List<Exercise> all = exerciseRepository.findAll();
        List<ExerciseDto> exerciseDtos = CopyUtil.copyList(all, ExerciseDto.class);
        return exerciseDtos;
    }

    public void update(ExerciseDto exerciseDto) {
        Exercise copy = CopyUtil.copy(exerciseDto, Exercise.class);
        exerciseRepository.insert(copy);
    }

    public ExerciseDto getByNo(Integer no) {
        Exercise result = exerciseRepository.findByExerciseNo(no);
        ExerciseDto exerciseDto = CopyUtil.copy(result, ExerciseDto.class);
        return exerciseDto;
    }

    public ExerciseDto getByTitle(String title) {
        Exercise result = exerciseRepository.findByTitleContaining(title);
        ExerciseDto exerciseDto = CopyUtil.copy(result, ExerciseDto.class);
        return exerciseDto;
    }

    public void delete(String id) {
        exerciseRepository.deleteById(id);
    }

}
