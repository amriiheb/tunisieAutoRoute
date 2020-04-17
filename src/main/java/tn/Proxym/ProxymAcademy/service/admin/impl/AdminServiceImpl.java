package tn.Proxym.ProxymAcademy.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dao.admin.AdminDao;
import tn.Proxym.ProxymAcademy.dto.AdminCreateDto;
import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.model.Admin;
import tn.Proxym.ProxymAcademy.model.Role;
import tn.Proxym.ProxymAcademy.model.User;
import tn.Proxym.ProxymAcademy.service.admin.AdminService;
import tn.Proxym.ProxymAcademy.service.role.RoleService;

import java.util.List;
import java.util.Optional;
@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    AdminDao adminDao;
    @Autowired
    RoleService roleService ;

    @Override
    public Admin createAdmin(UserCreateDto adminCreateDto) {
        String email = adminCreateDto.getEmail();
        String username = adminCreateDto.getUsername();
        String password = "Pr@xymAcademy1";

        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setActive(false);
        if(roleService.findById(1l).isPresent()) {
            Role role = roleService.findById(1l).get();
            admin.addRole(role);
        }



        return adminDao.create(admin);
    }

    @Override
    public List<Admin> findAll() {
        return  adminDao.findAll();
    }

    @Override
    public Optional<Admin> findByUsernameOrEmail(String username, String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return Optional.empty();
    }
}