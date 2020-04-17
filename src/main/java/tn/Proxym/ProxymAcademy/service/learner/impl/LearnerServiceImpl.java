package tn.Proxym.ProxymAcademy.service.learner.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dao.learner.LearnerDao;
import tn.Proxym.ProxymAcademy.dao.user.UserDao;
import tn.Proxym.ProxymAcademy.dao.verify_user.VerifyUserDao;
import tn.Proxym.ProxymAcademy.dto.LearnerCreateDto;
import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.mail.Mail;
import tn.Proxym.ProxymAcademy.mail.MailService;
import tn.Proxym.ProxymAcademy.model.Learner;
import tn.Proxym.ProxymAcademy.model.Role;
import tn.Proxym.ProxymAcademy.model.User;
import tn.Proxym.ProxymAcademy.model.VerifyAccount;
import tn.Proxym.ProxymAcademy.repository.LearnerRepository;
import tn.Proxym.ProxymAcademy.service.learner.LearnerService;
import tn.Proxym.ProxymAcademy.service.role.RoleService;
import tn.Proxym.ProxymAcademy.util.RandomUtil;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LearnerServiceImpl implements LearnerService {
    @Autowired
    private LearnerDao LearnerDao;

    @Autowired
    private RoleService roleService;

    @Override
    public Optional<Learner> findById(Long id) {
        return LearnerDao.findById(id);
    }

    @Override
    public Learner create(UserCreateDto learnerCreateDto)  {

        String email = learnerCreateDto.getEmail();
        String username = learnerCreateDto.getUsername();
        String password = "Pr@xym_Academy1";

        Learner account = new Learner();
        account.setEmail(email);
        account.setUsername(username);
        account.setPassword(password);
        account.setActive(false);

        if(roleService.findById(4l).isPresent()) {
            Role role = roleService.findById(4l).get();
            account.addRole(role);
        }



        return LearnerDao.create(account);
    }

    @Override
    public List<Learner> findAll() {
        return LearnerDao.findAll();
    }

}
