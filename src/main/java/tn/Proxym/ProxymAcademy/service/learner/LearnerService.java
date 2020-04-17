package tn.Proxym.ProxymAcademy.service.learner;

import tn.Proxym.ProxymAcademy.dto.LearnerCreateDto;
import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.model.Learner;
import tn.Proxym.ProxymAcademy.model.Role;

import java.util.List;
import java.util.Optional;

public interface LearnerService  {
    Optional<Learner> findById(Long id) ;
    Learner create (UserCreateDto learner) ;
    List<Learner> findAll() ;

}
