package br.com.treinos.APITreinos.service;

import br.com.treinos.APITreinos.entity.Exercise;
import br.com.treinos.APITreinos.repository.ExerciseRepository;
import br.com.treinos.APITreinos.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAllExercises(){
        return exerciseRepository.findAll();
    }

    public Optional<Exercise> getExerciseById(Long id){
        return exerciseRepository.findById(id);
    }

    public Exercise createExercise(Exercise exercise){
        return exerciseRepository.save(exercise);
    }

    public void deleteExercise(Long id){
        exerciseRepository.deleteById(id);
    }

    public Exercise updateExercise(Long id, Exercise updatedExercise){
        Optional<Exercise> existingExercise = exerciseRepository.findById(id);

        if (existingExercise.isPresent()){
            Exercise exercise = existingExercise.get();

            exercise.setName(updatedExercise.getName());
            exercise.setLoad(updatedExercise.getLoad());
            exercise.setRepetitions(updatedExercise.getRepetitions());
            exercise.setTrains(updatedExercise.getTrains());
            exercise.setRestTime(updatedExercise.getRestTime());

            return exerciseRepository.save(exercise);
        } else {
            throw new RuntimeException("Exercise not found!");
        }
    }


}
