package com.mis13.securityapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mis13.securityapp.repository.ParametroRepository;



@SpringBootApplication
//@EnableJpaRepositories("com.stardan.personservice.repository")
@EnableJpaRepositories(basePackageClasses= {ParametroRepository.class})
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SecurityappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityappApplication.class, args);
	}

}
