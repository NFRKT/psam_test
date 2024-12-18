package com.MyPatient.content_MyPatient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages = "com.MyPatient.Nurse")
@EnableJpaRepositories(basePackages = "com.MyPatient.Nurse")  // Skanuje repozytoria
@ComponentScan(basePackages = "com.MyPatient")
public class ContentMyPatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentMyPatientApplication.class, args);
		//SpringApplication.run(ControlerMyPatientHome.class, args);
	}
	@GetMapping
	public String hello(){
		return "Hello World";
	}

}
