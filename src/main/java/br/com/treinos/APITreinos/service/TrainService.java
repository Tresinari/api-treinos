package br.com.treinos.APITreinos.service;

import br.com.treinos.APITreinos.entity.Train;
import br.com.treinos.APITreinos.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService {

    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public List<Train> getAllTrains(){
        return trainRepository.findAll();
    }

    public Optional<Train> getTrainById(Long id){
        return trainRepository.findById(id);
    }

    public Train createTrain(Train train){
        return trainRepository.save(train);
    }

    public void deleteTrain(Long id){
        trainRepository.deleteById(id);
    }

    public Train updateTrain(Long id, Train updatedTrain){
        Optional<Train> existingTrain = trainRepository.findById(id);

        if (existingTrain.isPresent()){
            Train train = existingTrain.get();

            train.setName(updatedTrain.getName());
            train.setExercises(updatedTrain.getExercises());
            train.setWeekDate(updatedTrain.getWeekDate());

            return trainRepository.save(train);
        } else {
            throw new RuntimeException("Train not found!");
        }
    }

}
