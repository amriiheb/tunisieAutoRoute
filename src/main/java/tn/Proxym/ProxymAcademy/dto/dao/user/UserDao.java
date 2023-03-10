package tn.Proxym.ProxymAcademy.dto.dao.user;

import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.dto.dao.IOperations;
import tn.Proxym.ProxymAcademy.model.User;

import java.util.Optional;

@Repository
public interface UserDao  extends IOperations<User> {
    Optional<User> findByUsernameOrEmail(String username, String email) ;
    Optional<User>findByEmail(String mail) ;
    Optional<User> findByUsername(String username) ;

}
