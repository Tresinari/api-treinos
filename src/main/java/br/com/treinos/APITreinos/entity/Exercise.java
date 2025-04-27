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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Double getLoad() {
        return load;
    }

    public void setLoad(Double load) {
        this.load = load;
    }

    public Double getRestTime() {
        return restTime;
    }

    public void setRestTime(Double restTime) {
        this.restTime = restTime;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
}
