package tn.Proxym.ProxymAcademy.service.admin;

import tn.Proxym.ProxymAcademy.dto.AdminCreateDto;
import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.model.Admin;
import tn.Proxym.ProxymAcademy.model.User;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

public interface AdminService {


    public Admin createAdmin(UserCreateDto adminCreateDto) throws MessagingException;

    Optional<Admin> findByUsernameOrEmail(String username, String email) ;

    Optional<Admin> findByEmail(String email);

    Optional<Admin> findByUsername(String username)  ;

    Optional<Admin> findById(Long id);

    void Drop(Long id);

List<Admin> findAll() ;
    List<Admin> FindAllWithInheritance() ;


}
