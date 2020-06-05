package tn.Proxym.ProxymAcademy.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Configuration
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    String message = "";

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //UserPrincipal userPrincipal= (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getDetails() ;

        if(e.getClass()== DisabledException.class){
            httpServletResponse.sendRedirect("/verify-code");
        }



       // httpServletResponse.sendRedirect("/login");


    }







}
