package tn.Proxym.ProxymAcademy.dao.trainig_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;
import tn.Proxym.ProxymAcademy.repository.TrainingCategoryRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class Training_CategoryDaoImpl implements Training_CategoryDao{
    @Autowired
    private TrainingCategoryRepository trainingCategoryRepository ;



    @Override
    public Optional<TrainingCategory> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<TrainingCategory> findAll() {
        return trainingCategoryRepository.findAll();
    }

    @Override
    public TrainingCategory create(TrainingCategory entity) {
        return trainingCategoryRepository.save(entity);
    }

    @Override
    public TrainingCategory update(TrainingCategory entity) {
        return null;
    }

    @Override
    public void delete(TrainingCategory entity) {

    }

    @Override
    public void deleteById(long entityId) {
               trainingCategoryRepository.deleteById(entityId);
    }
}
