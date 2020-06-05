package tn.Proxym.ProxymAcademy.dao.training;

import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.dao.IOperations;
import tn.Proxym.ProxymAcademy.model.Training;

import java.util.List;

public interface TrainingDao  extends IOperations<Training> {
    List<Training> myTrainings(Long id) ;
}
