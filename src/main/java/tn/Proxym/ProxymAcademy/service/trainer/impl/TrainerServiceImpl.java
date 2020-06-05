package tn.Proxym.ProxymAcademy.service.trainer.impl;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dao.learner.LearnerDao;
import tn.Proxym.ProxymAcademy.dao.trainer.TrainerDao;
import tn.Proxym.ProxymAcademy.dao.verify_user.VerifyUserDao;
import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.mail.Mail;
import tn.Proxym.ProxymAcademy.mail.MailService;
import tn.Proxym.ProxymAcademy.model.*;
import tn.Proxym.ProxymAcademy.service.role.RoleService;
import tn.Proxym.ProxymAcademy.service.trainer.TrainerService;
import tn.Proxym.ProxymAcademy.util.RandomUtil;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TrainerServiceImpl  implements TrainerService {
    @Autowired
    TrainerDao trainerDao ;
    @Autowired
    RoleService roleService ;
    @Autowired
    private VerifyUserDao verifyUserDao ;
    @Autowired
    private MailService mailService ;

    @Override
    public Optional<Trainer> findById(Long id) {
        return trainerDao.findById(id);
    }

    @Override
    public List<Trainer> findAll() {
        return trainerDao.findAll();
    }

    @Override
    public void Drop(Long id) {
        Optional<Trainer> trainer=trainerDao.findById(id) ;
        trainerDao.delete(trainer.get());
    }

    @Override
    public List<Trainer> FindAllWithInheritance() {
        return trainerDao.FindAllWithInheritance();
    }

    @Override
    public Trainer create(UserCreateDto trainerCreateDto) throws MessagingException {
        trainerCreateDto.setUsername(trainerCreateDto.getFirstname()+trainerCreateDto.getLastname()+RandomUtil.generateRandomStringNumber(6).toUpperCase());
        String password = "Pr@xymAcademy1"+trainerCreateDto.getUsername();
        Mapper mapper=new DozerBeanMapper() ;
        Trainer trainer=mapper.map(trainerCreateDto,Trainer.class);
        trainer.setActive(false);
        trainer.setPassword(password);
        if(roleService.findById(3l).isPresent()) {
            Role role = roleService.findById(3l).get();
            trainer.addRole(role);
        }
        String token = RandomUtil.generateRandomStringNumber(6).toUpperCase();
        VerifyAccount verifyAccount = new VerifyAccount();
        verifyAccount.setAccount(trainer);
        verifyAccount.setCreatedDate(LocalDateTime.now());
        verifyAccount.setExpiredDataToken(5);
        verifyAccount.setToken(token);
        verifyUserDao.create(verifyAccount);

        Map<String, Object> maps = new HashMap<>();
        maps.put("account", trainer);
        maps.put("token", token);

        Mail mail = new Mail();
        mail.setFrom("ProxymAcademy.com");
        mail.setSubject("Registration");
        mail.setTo(trainer.getEmail());
        mail.setModel(maps);
        mailService.sendEmail(mail);

        return trainerDao.create(trainer);
    }
}
