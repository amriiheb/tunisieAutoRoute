package tn.Proxym.ProxymAcademy.service.role;

import tn.Proxym.ProxymAcademy.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findById(Long id) ;
    Role create (Role role) ;

}
