package tn.Proxym.ProxymAcademy.service.trainer;

import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.model.Learner;
import tn.Proxym.ProxymAcademy.model.Role;
import tn.Proxym.ProxymAcademy.model.Trainer;

import java.util.List;
import java.util.Optional;

public interface TrainerService {
    Optional<Trainer> findById(Long id) ;
    Trainer create (UserCreateDto trainer) ;
    List<Trainer> findAll() ;

}
