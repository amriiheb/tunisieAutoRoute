package tn.Proxym.ProxymAcademy.service.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dao.skill.SkillDao;
import tn.Proxym.ProxymAcademy.model.Skill;

import java.util.List;
import java.util.Optional;
@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    SkillDao skillDao ;
    @Override
    public Optional<Skill> findById(long id) {
        return skillDao.findById(id);
    }

    @Override
    public List<Skill> findAll() {
        return skillDao.findAll();
    }

    @Override
    public Skill create(Skill entity) {
        return skillDao.create(entity);
    }

    @Override
    public Skill update(Skill entity) {
        return skillDao.update(entity);
    }

    @Override
    public void delete(Skill entity) {
            skillDao.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
            skillDao.deleteById(entityId);
    }

    @Override
    public List<Skill> SkillsByUser(Long id) {
        return skillDao.SkillByUser(id);
    }
}
