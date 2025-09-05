package org.springrelffi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JavaSpringRelffiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringRelffiApplication.class, args);
	}

}
