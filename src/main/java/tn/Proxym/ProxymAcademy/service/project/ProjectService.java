package tn.Proxym.ProxymAcademy.service.project;

import tn.Proxym.ProxymAcademy.model.Project;
import tn.Proxym.ProxymAcademy.model.Training;
import tn.Proxym.ProxymAcademy.service.IOperationsService;

import java.util.List;

public interface ProjectService extends IOperationsService<Project> {
    List<Project> ProjectsByUser(Long id) ;

}
