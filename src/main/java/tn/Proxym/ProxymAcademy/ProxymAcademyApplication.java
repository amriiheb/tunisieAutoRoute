package tn.Proxym.ProxymAcademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.Proxym.ProxymAcademy.controller.training.NewCategory;

import java.io.File;

@SpringBootApplication
public class ProxymAcademyApplication {

	public static void main(String[] args) {
		new File(NewCategory.uploadDirectory).mkdir();

		SpringApplication.run(ProxymAcademyApplication.class, args);
	}

}
