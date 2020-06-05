package tn.Proxym.ProxymAcademy.service.skill;

import tn.Proxym.ProxymAcademy.model.Skill;
import tn.Proxym.ProxymAcademy.model.Training;
import tn.Proxym.ProxymAcademy.service.IOperationsService;

import java.util.List;

public interface SkillService extends IOperationsService<Skill> {
    List<Skill> SkillsByUser(Long id) ;

}
