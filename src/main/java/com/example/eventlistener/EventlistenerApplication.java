package com.example.eventlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventlistenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventlistenerApplication.class, args);
	}

}
