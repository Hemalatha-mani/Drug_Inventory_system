package com.hemalatha.druginventory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DruginventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DruginventoryApplication.class, args);
	}

}
