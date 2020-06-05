package tn.Proxym.ProxymAcademy.dao.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.model.Skill;
import tn.Proxym.ProxymAcademy.repository.SkillRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class SkillDaoImpl implements SkillDao {
    @Autowired
    SkillRepository skillRepository ;
    @Override
    public Optional<Skill> findById(long id) {
        return skillRepository.findById(id);
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Skill create(Skill entity) {
        return skillRepository.save(entity);
    }

    @Override
    public Skill update(Skill entity) {
        return skillRepository.save(entity);
    }

    @Override
    public void delete(Skill entity) {
           skillRepository.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
              skillRepository.deleteById(entityId);
    }

    @Override
    public List<Skill> SkillByUser(Long id) {
        return skillRepository.SkillsByUser(id);
    }
}
