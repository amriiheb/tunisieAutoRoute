package tn.Proxym.ProxymAcademy.service.learner.impl;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
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
    @Autowired
    private VerifyUserDao verifyUserDao ;
    @Autowired
    private MailService mailService ;

    @Override
    public Optional<Learner> findById(Long id) {
        return LearnerDao.findById(id);
    }
    @Override
    public void Drop(Long id) {
        Optional<Learner> learner=LearnerDao.findById(id) ;
               LearnerDao.delete(learner.get());

    }

    @Override
    public List<Learner> FindAllWithInheritance() {
        return LearnerDao.FindAllWithInheritance();
    }

    @Override
    public Learner create(UserCreateDto learnerCreateDto) throws MessagingException {
        learnerCreateDto.setUsername(learnerCreateDto.getFirstname()+learnerCreateDto.getLastname()+RandomUtil.generateRandomStringNumber(6).toUpperCase());
        String password = "Pr@xymAcademy1"+learnerCreateDto.getUsername();
        Mapper mapper=new DozerBeanMapper() ;
        Learner learner=mapper.map(learnerCreateDto,Learner.class);
        learner.setPassword(password);
        learner.setActive(false);
        if(roleService.findById(4l).isPresent()) {
            Role role = roleService.findById(4l).get();
            learner.addRole(role);
        }
        String token = RandomUtil.generateRandomStringNumber(6).toUpperCase();
        VerifyAccount verifyAccount = new VerifyAccount();
        verifyAccount.setAccount(learner);
        verifyAccount.setCreatedDate(LocalDateTime.now());
        verifyAccount.setExpiredDataToken(5);
        verifyAccount.setToken(token);
        verifyUserDao.create(verifyAccount);

        Map<String, Object> maps = new HashMap<>();
        maps.put("account", learner);
        maps.put("token", token);

        Mail mail = new Mail();
        mail.setFrom("ProxymAcademy.com");
        mail.setSubject("Registration");
        mail.setTo(learner.getEmail());
        mail.setModel(maps);
        mailService.sendEmail(mail);


        return LearnerDao.create(learner);
    }

    @Override
    public List<Learner> findAll() {
        return LearnerDao.findAll();
    }

}
