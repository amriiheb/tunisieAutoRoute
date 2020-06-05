package tn.Proxym.ProxymAcademy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.model.User;
import tn.Proxym.ProxymAcademy.service.user.UserService;

import javax.transaction.Transactional;
@Service
public class CustomDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

            User user =  userService.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).get();


         if (user != null) {
            return UserPrincipal.create(user);
        }

         if(user.isActive()==false){
             throw  new UsernameNotFoundException("User not activated "+user.getId()) ;
         }

        throw new UsernameNotFoundException("User  not found");
    }

}