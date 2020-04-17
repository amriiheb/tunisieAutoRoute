package tn.Proxym.ProxymAcademy.dao.trainer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.dao.trainer.TrainerDao;
import tn.Proxym.ProxymAcademy.model.Trainer;
import tn.Proxym.ProxymAcademy.repository.TrainerRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class TrainerDaoImpl implements TrainerDao {
    @Autowired
    TrainerRepository trainerRepository ;


    @Override
    public Optional<Trainer> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer create(Trainer entity) {
        return trainerRepository.save(entity);
    }

    @Override
    public Trainer update(Trainer entity) {
        return null;
    }

    @Override
    public void delete(Trainer entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }
}
