package com.google.linkedinlight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LinkedinlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkedinlightApplication.class, args);
	}

}
