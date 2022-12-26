package tn.Proxym.ProxymAcademy.service.admin.impl;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dto.dao.admin.AdminDao;
import tn.Proxym.ProxymAcademy.dto.dao.verify_user.VerifyUserDao;
import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.mail.Mail;
import tn.Proxym.ProxymAcademy.mail.MailService;
import tn.Proxym.ProxymAcademy.model.*;
import tn.Proxym.ProxymAcademy.service.admin.AdminService;
import tn.Proxym.ProxymAcademy.service.role.RoleService;
import tn.Proxym.ProxymAcademy.util.RandomUtil;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    AdminDao adminDao;
    @Autowired
    RoleService roleService ;
    @Autowired
    private VerifyUserDao verifyUserDao ;
    @Autowired
    private MailService mailService ;

    @Override
    public void Drop(Long id) {
        Optional<Admin> admin=adminDao.findById(id) ;
        adminDao.delete(admin.get());    }

    @Override
    public Admin createAdmin(UserCreateDto adminCreateDto) throws MessagingException {
        adminCreateDto.setUsername(adminCreateDto.getFirstname()+adminCreateDto.getLastname()+RandomUtil.generateRandomStringNumber(6).toUpperCase());
        String password = "Pr@xymAcademy1"+adminCreateDto.getUsername();

        Mapper mapper=new DozerBeanMapper() ;
        Admin admin=mapper.map(adminCreateDto,Admin.class);
        admin.setActive(true);
        admin.setPassword(password);
        if(roleService.findById(1l).isPresent()) {
            Role role = roleService.findById(1l).get();
            admin.addRole(role);
        }
        String token = RandomUtil.generateRandomStringNumber(6).toUpperCase();
        VerifyAccount verifyAccount = new VerifyAccount();
        verifyAccount.setAccount(admin);
        verifyAccount.setCreatedDate(LocalDateTime.now());
        verifyAccount.setExpiredDataToken(5);
        verifyAccount.setToken(token);
        verifyUserDao.create(verifyAccount);

        Map<String, Object> maps = new HashMap<>();
        maps.put("account", admin);
        maps.put("token", token);

        Mail mail = new Mail();
        mail.setFrom("ProxymAcademy.com");
        mail.setSubject("Registration");
        mail.setTo(admin.getEmail());
        mail.setModel(maps);
        mailService.sendEmail(mail);

        return adminDao.create(admin);
    }

    @Override
    public List<Admin> FindAllWithInheritance() {
        return adminDao.FindAllWithInheritance();
    }

    @Override
    public List<Admin> findAll() {
        return  adminDao.findAll();
    }

    @Override
    public Optional<Admin> findByUsernameOrEmail(String username, String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return Optional.empty();
    }
}