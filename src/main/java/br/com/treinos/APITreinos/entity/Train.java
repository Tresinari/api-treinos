package br.com.treinos.APITreinos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercise> exercises;
    @Getter
    @Setter
    private String weekDate;

    public Train(){}

    public Train(String name, List<Exercise> exercises, String weekDate) {
        this.name = name;
        this.exercises = exercises;
        this.weekDate = weekDate;
    }
}
