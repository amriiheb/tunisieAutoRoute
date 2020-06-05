package tn.Proxym.ProxymAcademy.service.module;

import tn.Proxym.ProxymAcademy.dao.IOperations;
import tn.Proxym.ProxymAcademy.model.Learner;
import tn.Proxym.ProxymAcademy.model.Module;
import tn.Proxym.ProxymAcademy.service.IOperationsService;

public interface ModuleService extends IOperationsService<Module> {
    void Drop(Long id) ;

}
