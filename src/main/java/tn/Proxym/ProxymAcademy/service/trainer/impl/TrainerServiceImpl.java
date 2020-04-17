package tn.Proxym.ProxymAcademy.service.trainer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dao.learner.LearnerDao;
import tn.Proxym.ProxymAcademy.dao.trainer.TrainerDao;
import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.model.Admin;
import tn.Proxym.ProxymAcademy.model.Learner;
import tn.Proxym.ProxymAcademy.model.Role;
import tn.Proxym.ProxymAcademy.model.Trainer;
import tn.Proxym.ProxymAcademy.service.role.RoleService;
import tn.Proxym.ProxymAcademy.service.trainer.TrainerService;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl  implements TrainerService {
    @Autowired
    TrainerDao trainerDao ;
    @Autowired
    RoleService roleService ;

    @Override
    public Optional<Trainer> findById(Long id) {
        return trainerDao.findById(id);
    }

    @Override
    public List<Trainer> findAll() {
        return trainerDao.findAll();
    }

    @Override
    public Trainer create(UserCreateDto user) {
        String email = user.getEmail();
        String username = user.getUsername();
        String password = "Pr@xymAcademy1";
        Trainer trainer = new Trainer();
        trainer.setEmail(email);
        trainer.setUsername(username);
        trainer.setPassword(password);
        trainer.setActive(false);
        if(roleService.findById(3l).isPresent()) {
            Role role = roleService.findById(3l).get();
            trainer.addRole(role);
        }


        return trainerDao.create(trainer);
    }
}
