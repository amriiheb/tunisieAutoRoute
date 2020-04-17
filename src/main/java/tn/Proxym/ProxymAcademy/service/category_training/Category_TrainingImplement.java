package tn.Proxym.ProxymAcademy.service.category_training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dao.trainig_category.Training_CategoryDao;
import tn.Proxym.ProxymAcademy.dto.trainingCategory.TrainingCategoryDto;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
@Service
public class Category_TrainingImplement implements Category_TrainingService {

    @Autowired
    private Training_CategoryDao training_categoryDao ;


    @Override
    public Optional<TrainingCategory> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public TrainingCategory create(TrainingCategoryDto trainingCategoryDto, String path)
    {
        TrainingCategory trainingCategory=new TrainingCategory() ;
        trainingCategory.setName(trainingCategoryDto.getName());
        trainingCategory.setPathImage(path);

        return training_categoryDao.create(trainingCategory);
    }

    @Override
    public List<TrainingCategory> findAll() {
        return training_categoryDao.findAll();
    }
}