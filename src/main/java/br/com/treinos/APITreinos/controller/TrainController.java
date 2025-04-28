package br.com.treinos.APITreinos.controller;

import br.com.treinos.APITreinos.dto.TrainDTO;
import br.com.treinos.APITreinos.entity.Train;
import br.com.treinos.APITreinos.mapper.TrainMapper;
import br.com.treinos.APITreinos.service.TrainService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trains")
public class TrainController {

    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    TrainMapper trainMapper(){
        return new TrainMapper();
    }

    public List<TrainDTO> getAllTrains(){
        return trainService.getAllTrains()
                .stream()
                .map(TrainMapper::toDTO)
                .toList();
    }

    public Optional<Train> getTrainById(@PathVariable Long id){
        return trainService.getTrainById(id);
    }

    public ResponseEntity<TrainDTO> createTrain(@RequestBody TrainDTO newTrain){
        TrainDTO train = new TrainDTO(
                newTrain.getName(),
                newTrain.getExercises(),
                newTrain.getWeekDate()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(train);
    }

    public void deleteTrainById(Long id){
        trainService.deleteTrain(id);
    }
}
