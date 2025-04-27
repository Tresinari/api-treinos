package br.com.treinos.APITreinos.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer repetitions;
    private Double load; //weight used at this exercise
    private Double restTime; //rest time calculated in seconds
    @ManyToMany(mappedBy = "exercicios")
    private List<Train> trains;

    protected Exercise(){}

    public Exercise(String name, Integer repetitions, Double load, Double restTime, List<Train> trains) {
        this.name = name;
        this.repetitions = repetitions;
        this.load = load;
        this.restTime = restTime;
        this.trains = Exercise.this.trains;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public Double getLoad() {
        return load;
    }

    public Double getRestTime() {
        return restTime;
    }

    public List<Train> getTrains() {
        return trains;
    }
}
