package br.com.treinos.APITreinos.mapper;

import br.com.treinos.APITreinos.dto.TrainDTO;
import br.com.treinos.APITreinos.entity.Train;

import java.util.stream.Collectors;

public class TrainMapper {

    public static TrainDTO toDTO(Train train){
        if (train == null) return null;

        TrainDTO dto = new TrainDTO();
        dto.setName(train.getName());

        if (train.getExercises() != null){
            dto.setExercises(
                    train.getExercises().stream()
                            .map(ExerciseMapper::toDTO)
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }

    public static Train toEntity(TrainDTO dto){
        if (dto == null) return null;

        Train train = new Train();
        train.setName(dto.getName());
        if (dto.getExercises() != null){
            train.setExercises(
                    dto.getExercises().stream()
                            .map(ExerciseMapper::toEntity)
                            .collect(Collectors.toList())
            );
        }
        return train;
    }


}
