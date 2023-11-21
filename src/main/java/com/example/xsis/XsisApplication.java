package com.example.xsis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class XsisApplication {

	public static void main(String[] args) {
		SpringApplication.run(XsisApplication.class, args);
	}

}
