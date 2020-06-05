package tn.Proxym.ProxymAcademy.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import tn.Proxym.ProxymAcademy.model.User;
import tn.Proxym.ProxymAcademy.security.UserPrincipal;
import tn.Proxym.ProxymAcademy.service.user.UserService;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

@Autowired
	UserService userService ;



	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
        UserPrincipal userPrincipal=(UserPrincipal) authentication.getPrincipal() ;
		return Optional.of(userPrincipal.getUsername());

	}



}