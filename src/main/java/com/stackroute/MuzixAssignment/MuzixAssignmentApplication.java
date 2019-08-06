package com.stackroute.MuzixAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //to track and log every change
public class MuzixAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuzixAssignmentApplication.class, args);
	}

}
