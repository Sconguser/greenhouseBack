package com.greenhouse.greenhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

///TODO: vulnerability w dependencies
@SpringBootApplication
@ComponentScan({"com.greenhouse.greenhouse.repositories"}) /// TODO: zobaczyc co to
public class GreenhouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenhouseApplication.class, args);
	}

}
