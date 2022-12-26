package tn.Proxym.ProxymAcademy.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dto.dao.user.UserDao;
import tn.Proxym.ProxymAcademy.dto.dao.verify_user.VerifyUserDao;
import tn.Proxym.ProxymAcademy.dto.UserCreateDto;
import tn.Proxym.ProxymAcademy.dto.VerifyCodeDto;
import tn.Proxym.ProxymAcademy.mail.Mail;
import tn.Proxym.ProxymAcademy.mail.MailService;
import tn.Proxym.ProxymAcademy.model.Role;
import tn.Proxym.ProxymAcademy.model.User;
import tn.Proxym.ProxymAcademy.model.VerifyAccount;
import tn.Proxym.ProxymAcademy.service.role.RoleService;
import tn.Proxym.ProxymAcademy.service.user.UserService;
import tn.Proxym.ProxymAcademy.util.RandomUtil;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao accountDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private VerifyUserDao verifyUserDao;


    @Autowired
    private MailService mailService;

    @Override
    public void updateUser(User user) {
        accountDao.update(user);

    }

    @Override
    public User createMember(UserCreateDto accountDto) throws MessagingException {

        String email = accountDto.getEmail();
        String username = accountDto.getUsername();
        String password = accountDto.getPassword();

        User account = new User();
        account.setEmail(email);
        account.setUsername(username);
        account.setPassword(password);
        account.setActive(false);

        if (roleService.findById(2l).isPresent()) {
            Role role = roleService.findById(2l).get();
            account.addRole(role);
        }

        String token = RandomUtil.generateRandomStringNumber(6).toUpperCase();

        VerifyAccount verifyAccount = new VerifyAccount();
        verifyAccount.setAccount(account);
        verifyAccount.setCreatedDate(LocalDateTime.now());
        verifyAccount.setExpiredDataToken(5);
        verifyAccount.setToken(token);
        verifyUserDao.create(verifyAccount);

        Map<String, Object> maps = new HashMap<>();
        maps.put("account", account);
        maps.put("token", token);

        Mail mail = new Mail();
        mail.setFrom("ProxymAcademy.com");
        mail.setSubject("Registration");
        mail.setTo(account.getEmail());
        mail.setModel(maps);
        mailService.sendEmail(mail);

        return accountDao.create(account);
    }

    @Override
    public User createAdmin(UserCreateDto accountDto) {
        String email = accountDto.getEmail();
        String username = accountDto.getUsername();
        String password = accountDto.getPassword();

        User account = new User();
        account.setEmail(email);
        account.setUsername(username);
        account.setPassword(password);
        if (roleService.findById(2l).isPresent()) {
            Role role = roleService.findById(2l).get();
            account.addRole(role);
        }


        return accountDao.create(account);
    }

    @Override
    public Optional<User> findByUsernameOrEmail(String username, String email) {
        return accountDao.findByUsernameOrEmail(username, email);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return accountDao.findByEmail(email);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return accountDao.findByUsername(username);
    }

    @Override
    public Optional<User> findById(Long id) {
        return accountDao.findById(id);
    }


    public void verifyCode(VerifyCodeDto verifyCodeDto) {

        String token = verifyCodeDto.getToken();

        VerifyAccount verifyAccount = verifyUserDao.findByToken(token).get();
        User account = verifyAccount.getAccount();
        account.setActive(true);
        accountDao.update(account);
    }
}
