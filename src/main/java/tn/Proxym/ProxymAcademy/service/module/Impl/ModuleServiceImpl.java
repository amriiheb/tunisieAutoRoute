package tn.Proxym.ProxymAcademy.service.module.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dao.module.ModuleDao;
import tn.Proxym.ProxymAcademy.model.Module;
import tn.Proxym.ProxymAcademy.service.module.ModuleService;

import java.util.List;
import java.util.Optional;
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleDao moduleDao ;

    @Override
    public void Drop(Long id) {
        moduleDao.deleteById(id) ;
    }

    @Override
    public Optional<Module> findById(long id) {
        return moduleDao.findById(id);
    }

    @Override
    public List<Module> findAll() {
        return moduleDao.findAll();
    }

    @Override
    public Module create(Module entity) {
        return moduleDao.create(entity);
    }

    @Override
    public Module update(Module entity) {
        return moduleDao.update(entity);
    }

    @Override
    public void delete(Module entity) {
        moduleDao.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        moduleDao.deleteById(entityId);

    }
}
