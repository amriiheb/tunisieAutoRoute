package tn.Proxym.ProxymAcademy.dao.training.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.dao.training.TrainingDao;
import tn.Proxym.ProxymAcademy.model.Training;
import tn.Proxym.ProxymAcademy.repository.TrainingRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class TrainingDaoimpl implements TrainingDao {
    @Override
    public List<Training> myTrainings(Long id) {
        return trainingRepository.myTrainings(id);
    }

    @Autowired
    private TrainingRepository trainingRepository ;
    @Override
    public Optional<Training> findById(long id) {
        return trainingRepository.findById(id);
    }

    @Override
    public List<Training> findAll() {
        return trainingRepository.findAll();
    }

    @Override
    public Training create(Training entity) {
        return trainingRepository.save(entity) ;
    }

    @Override
    public Training update(Training entity) {
        return null;
    }

    @Override
    public void delete(Training entity) {

    }

    @Override
    public void deleteById(long entityId) {
        trainingRepository.deleteById(entityId);

    }
}
