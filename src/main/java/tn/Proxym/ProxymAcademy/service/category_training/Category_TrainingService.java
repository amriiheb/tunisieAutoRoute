package tn.Proxym.ProxymAcademy.service.category_training;

import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.dto.trainingCategory.TrainingCategoryDto;
import tn.Proxym.ProxymAcademy.model.Trainer;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public interface Category_TrainingService {

    Optional<TrainingCategory> findById(Long id) ;
    TrainingCategory create (TrainingCategoryDto trainingCategoryDto, String path) ;
    List<TrainingCategory> findAll() ;

    void Drop(Long id1);
}
