package com.rfvallina.itemsfeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ItemsFeedApp {

	public static void main(String[] args) {
		SpringApplication.run(ItemsFeedApp.class, args);
	}

}
