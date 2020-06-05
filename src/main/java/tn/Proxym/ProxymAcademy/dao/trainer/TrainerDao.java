package tn.Proxym.ProxymAcademy.dao.trainer;

import tn.Proxym.ProxymAcademy.dao.IOperations;
import tn.Proxym.ProxymAcademy.model.Admin;
import tn.Proxym.ProxymAcademy.model.Trainer;

import java.util.List;

public interface TrainerDao extends IOperations<Trainer> {
    List<Trainer> FindAllWithInheritance() ;
}
