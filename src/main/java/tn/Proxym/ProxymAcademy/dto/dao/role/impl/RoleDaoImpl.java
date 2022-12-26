package tn.Proxym.ProxymAcademy.dao.role.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.dao.role.RoleDao;
import tn.Proxym.ProxymAcademy.model.Role;
import tn.Proxym.ProxymAcademy.repository.RoleRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private RoleRepository RoleRepository ;
    @Override
    public Optional<Role> findById(long id) {
        return RoleRepository.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return RoleRepository.findAll() ;
    }

    @Override
    public Role create(Role entity) {
        return RoleRepository.save(entity);
    }

    @Override
    public Role update(Role entity) {
        return RoleRepository.save(entity);
    }

    @Override
    public void delete(Role entity) {
           RoleRepository.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
          RoleRepository.deleteById(entityId);
    }
}
