package tn.Proxym.ProxymAcademy.dao.project;

import tn.Proxym.ProxymAcademy.dao.IOperations;
import tn.Proxym.ProxymAcademy.model.Project;
import tn.Proxym.ProxymAcademy.model.Training;

import java.util.List;

public interface ProjectDao extends IOperations<Project> {
    List<Project> ProjectsByUser(Long id) ;


}
