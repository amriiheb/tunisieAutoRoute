package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.Proxym.ProxymAcademy.model.Skill;
import tn.Proxym.ProxymAcademy.model.Training;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill,Long> {
    @Query("select e from Skill  e where e.user.id=?1")
    List<Skill> SkillsByUser(Long id) ;
}
