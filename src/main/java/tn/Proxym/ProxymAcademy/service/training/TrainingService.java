package tn.Proxym.ProxymAcademy.service.training;

import tn.Proxym.ProxymAcademy.dto.training.TrainingCreateDtoA;
import tn.Proxym.ProxymAcademy.model.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingService  {
    Training create(TrainingCreateDtoA TrainingCreateDtoA) ;
    List<Training> myTrainings(Long id) ;
    List<Training> findAll() ;
    void drop(Long id) ;
    Optional<Training> findById(Long id);
}
