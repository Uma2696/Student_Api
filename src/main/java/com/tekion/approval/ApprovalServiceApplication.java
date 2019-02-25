package com.tekion.approval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, WebMvcAutoConfiguration.class})
@SpringBootApplication
public class ApprovalServiceApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ApprovalServiceApplication.class);
		app.run(args);

	}

}

