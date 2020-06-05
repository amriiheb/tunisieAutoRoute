package tn.Proxym.ProxymAcademy;

import org.kurento.client.KurentoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import tn.Proxym.ProxymAcademy.audit.SpringSecurityAuditorAware;
import tn.Proxym.ProxymAcademy.controller.admin.training.Category;
import tn.Proxym.ProxymAcademy.groupcall.RoomManager;
import tn.Proxym.ProxymAcademy.groupcall.UserRegistry;
import tn.Proxym.ProxymAcademy.model.User;
import tn.Proxym.ProxymAcademy.one2manycall.CallHandler;

import java.io.File;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableWebSocket
public class ProxymAcademyApplication implements WebSocketConfigurer {
	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	}
	@Bean
	public CallHandler callHandler() {
		return new CallHandler();
	}

	@Bean
	public KurentoClient kurentoClient() {
		return KurentoClient.create();
	}

	@Bean
	public tn.Proxym.ProxymAcademy.groupcall.CallHandler groupCallHandler() {
		return new tn.Proxym.ProxymAcademy.groupcall.CallHandler();
	}

	@Bean
	public UserRegistry registry() {
		return new UserRegistry();
	}

	@Bean
	public RoomManager roomManager() {
		return new RoomManager();
	}



	public static void main(String[] args) throws  Exception {
		new File(Category.uploadDirectory).mkdir();

		SpringApplication.run(ProxymAcademyApplication.class, args);
	}
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(groupCallHandler(), "/groupcall");
	}
}
