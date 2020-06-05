package tn.Proxym.ProxymAcademy.service.account_verify.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dao.user.UserDao;
import tn.Proxym.ProxymAcademy.dao.verify_user.VerifyUserDao;
import tn.Proxym.ProxymAcademy.model.VerifyAccount;
import tn.Proxym.ProxymAcademy.service.account_verify.VerifyAccountService;

import java.util.Optional;
@Service
public class VerifyAccountServiceImpl implements VerifyAccountService {
   @Autowired
   private VerifyUserDao verifyUserDao;
   @Autowired
   private UserDao accountDao ;
   @Override
    public VerifyAccount create(VerifyAccount verifyAccount) {
        return verifyUserDao.create(verifyAccount);
    }

    @Override
    public Optional<VerifyAccount> findByToken(String token) {
        return verifyUserDao.findByToken(token) ;
    }

    @Override
    public Optional<VerifyAccount> findById(Long id) {
        return verifyUserDao.findById(id) ;
    }
}
