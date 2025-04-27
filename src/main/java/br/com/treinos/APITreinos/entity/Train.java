package br.com.treinos.APITreinos.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "treino_exercicio",
            joinColumns = @JoinColumn(name = "treino_id"),
            inverseJoinColumns = @JoinColumn(name = "exercicio_id")
    )
    private List<Exercise> exercises;
    private String weekDate;

    protected Train(){}

    public Train(String name, List<Exercise> exercises, String weekDate) {
        this.name = name;
        this.exercises = exercises;
        this.weekDate = weekDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public String getWeekDate() {
        return weekDate;
    }
}
