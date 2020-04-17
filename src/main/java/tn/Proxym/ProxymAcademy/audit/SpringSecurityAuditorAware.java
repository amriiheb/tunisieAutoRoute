package tn.Proxym.ProxymAcademy.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import tn.Proxym.ProxymAcademy.model.User;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<User> {


	@Override
	public Optional<User> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
		return (Optional<User>) authentication.getPrincipal();


	}



}