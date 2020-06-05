package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.Proxym.ProxymAcademy.model.VerifyAccount;

import java.util.Optional;

public interface VerifyAccountRepository extends JpaRepository<VerifyAccount,Long> {
    Optional<VerifyAccount> findByToken(String token) ;

}
