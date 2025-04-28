package br.com.treinos.APITreinos.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class ExerciseDTO {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Integer repetitions;
    @Getter
    @Setter
    private Double load; //weight used at this exercise
    @Getter
    @Setter
    private Double restTime; //rest time calculated in seconds

    public ExerciseDTO(){}

    public ExerciseDTO(String name, Integer repetitions, Double load, Double restTime) {
        this.name = name;
        this.repetitions = repetitions;
        this.load = load;
        this.restTime = restTime;
    }
}
