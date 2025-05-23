package br.com.treinos.APITreinos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    public Exercise(){}

    public Exercise(String name, Integer repetitions, Double load, Double restTime) {
        this.name = name;
        this.repetitions = repetitions;
        this.load = load;
        this.restTime = restTime;
    }
}
