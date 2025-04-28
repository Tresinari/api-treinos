package br.com.treinos.APITreinos.dto;

import br.com.treinos.APITreinos.entity.Exercise;
import br.com.treinos.APITreinos.entity.Train;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class TrainDTO {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseDTO> exercises;
    @Getter
    @Setter
    private String weekDate;

    public TrainDTO(){}

    public TrainDTO(String name, List<ExerciseDTO> exercises, String weekDate) {
        this.name = name;
        this.exercises = exercises;
        this.weekDate = weekDate;
    }
}
