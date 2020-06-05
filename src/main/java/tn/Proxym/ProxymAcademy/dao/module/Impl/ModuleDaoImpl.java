package tn.Proxym.ProxymAcademy.dao.module.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.dao.module.ModuleDao;
import tn.Proxym.ProxymAcademy.model.Module;
import tn.Proxym.ProxymAcademy.repository.ModuleRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class ModuleDaoImpl implements ModuleDao {
    @Autowired
    ModuleRepository moduleRepository ;
    @Override
    public Optional<Module> findById(long id) {
        return moduleRepository.findById(id);
    }

    @Override
    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    @Override
    public Module create(Module entity) {
        return moduleRepository.save(entity);
    }

    @Override
    public Module update(Module entity) {
        return moduleRepository.save(entity);
    }

    @Override
    public void delete(Module entity) {
               moduleRepository.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
moduleRepository.deleteById(entityId);
    }
}
