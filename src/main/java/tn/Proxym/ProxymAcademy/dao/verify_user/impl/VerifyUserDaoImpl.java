package tn.Proxym.ProxymAcademy.dao.verify_user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.dao.verify_user.VerifyUserDao;
import tn.Proxym.ProxymAcademy.model.VerifyAccount;
import tn.Proxym.ProxymAcademy.repository.VerifyAccountRepository;

import java.util.Optional;
@Repository
public class VerifyUserDaoImpl implements VerifyUserDao {
    @Autowired
    private VerifyAccountRepository verifyAccountRepository;

    @Override
    public VerifyAccount create(VerifyAccount verifyAccount) {
        return verifyAccountRepository.save(verifyAccount);
    }

    @Override
    public Optional<VerifyAccount> findByToken(String token) {
        return verifyAccountRepository.findByToken(token);
    }

    @Override
    public Optional<VerifyAccount> findById(Long id) {
        return verifyAccountRepository.findById(id);
    }

}
