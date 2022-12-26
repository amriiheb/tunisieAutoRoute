package tn.Proxym.ProxymAcademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import tn.Proxym.ProxymAcademy.audit.SpringSecurityAuditorAware;

@SpringBootApplication
@EnableScheduling
public class ProxymAcademyApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProxymAcademyApplication.class, args);
    }
}
