package tn.Proxym.ProxymAcademy.service.account_verify;

import tn.Proxym.ProxymAcademy.model.VerifyAccount;

import java.util.Optional;

public interface VerifyAccountService {


    VerifyAccount create (VerifyAccount verifyAccount) ;
    Optional<VerifyAccount> findByToken(String token) ;
    Optional<VerifyAccount> findById(Long id) ;
}
