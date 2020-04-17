package tn.Proxym.ProxymAcademy.dao.learner.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.dao.learner.LearnerDao;
import tn.Proxym.ProxymAcademy.model.Learner;
import tn.Proxym.ProxymAcademy.repository.LearnerRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class LearnDaoImpl implements LearnerDao {

    @Autowired
    LearnerRepository learnerRepository ;

    @Override
    public Optional<Learner> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Learner> findAll() {
        return learnerRepository.findAll();
    }

    @Override
    public Learner create(Learner entity) {
        return learnerRepository.save(entity);
    }

    @Override
    public Learner update(Learner entity) {
        return null;
    }

    @Override
    public void delete(Learner entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }
}
