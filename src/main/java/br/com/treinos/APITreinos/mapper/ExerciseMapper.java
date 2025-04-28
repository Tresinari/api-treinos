package br.com.treinos.APITreinos.mapper;

import br.com.treinos.APITreinos.dto.ExerciseDTO;
import br.com.treinos.APITreinos.entity.Exercise;

public class ExerciseMapper {

    public static Exercise toEntity(ExerciseDTO dto){
        if (dto == null) return null;

        Exercise exercise = new Exercise();
        exercise.setName(dto.getName());
        exercise.setLoad(dto.getLoad());
        exercise.setRepetitions(dto.getRepetitions());
        exercise.setRestTime(dto.getRestTime());

        return exercise;
    }

    public static ExerciseDTO toDTO(Exercise exercise){
        if (exercise == null) return null;

        ExerciseDTO dto = new ExerciseDTO();
        dto.setName(exercise.getName());
        dto.setLoad(exercise.getLoad());
        dto.setRepetitions(exercise.getRepetitions());
        dto.setRestTime(exercise.getRestTime());

        return dto;
    }

}
