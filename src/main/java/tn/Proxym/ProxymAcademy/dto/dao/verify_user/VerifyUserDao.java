package tn.Proxym.ProxymAcademy.dto.dao.verify_user;

import tn.Proxym.ProxymAcademy.model.VerifyAccount;

import java.util.Optional;
public interface VerifyUserDao {
    VerifyAccount create (VerifyAccount VerifyAccount) ;
    Optional<VerifyAccount> findByToken(String token) ;
    Optional<VerifyAccount> findById(Long id) ;
}
