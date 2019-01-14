package com.foreignkey.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(StudentApplication.class);
		app.run(args);

	}

}

