package tn.Proxym.ProxymAcademy.service.training;

import tn.Proxym.ProxymAcademy.dto.training.TrainingCreateDtoA;
import tn.Proxym.ProxymAcademy.model.Training;

public interface TrainingService  {
    Training create(TrainingCreateDtoA TrainingCreateDtoA) ;
}
