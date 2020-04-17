package tn.Proxym.ProxymAcademy.service.user;

import tn.Proxym.ProxymAcademy.dto.UserCreateDto;
import tn.Proxym.ProxymAcademy.dto.VerifyCodeDto;
import tn.Proxym.ProxymAcademy.model.User;

import java.util.Optional;

public interface UserService {
    public User createMember(UserCreateDto accountDto) throws Exception;

    public User createAdmin(UserCreateDto accountDto);

    Optional<User> findByUsernameOrEmail(String username, String email) ;

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username)  ;

    Optional<User> findById(Long id);

    public void verifyCode(VerifyCodeDto verifyCodeDto);

}

