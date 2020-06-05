package tn.Proxym.ProxymAcademy.dao.learner;

import tn.Proxym.ProxymAcademy.dao.IOperations;
import tn.Proxym.ProxymAcademy.model.Admin;
import tn.Proxym.ProxymAcademy.model.Learner;

import java.util.List;

public interface LearnerDao extends IOperations<Learner> {
    List<Learner> FindAllWithInheritance() ;

}
