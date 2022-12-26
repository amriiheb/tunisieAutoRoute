package tn.Proxym.ProxymAcademy.service.role.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dto.dao.role.RoleDao;
import tn.Proxym.ProxymAcademy.model.Role;
import tn.Proxym.ProxymAcademy.service.role.RoleService;

import java.util.Optional;

@Service
public class RoleServiceImpl  implements RoleService {

    @Autowired
    private RoleDao roleDao ;


    @Override
    public Optional<Role> findById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public Role create(Role role) {
        return null;
    }
}
