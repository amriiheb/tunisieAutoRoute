package tn.Proxym.ProxymAcademy.dao.skill;

import tn.Proxym.ProxymAcademy.dao.IOperations;
import tn.Proxym.ProxymAcademy.model.Skill;
import tn.Proxym.ProxymAcademy.model.Training;

import java.util.List;

public interface SkillDao  extends IOperations<Skill> {
    List<Skill> SkillByUser(Long id) ;

}
