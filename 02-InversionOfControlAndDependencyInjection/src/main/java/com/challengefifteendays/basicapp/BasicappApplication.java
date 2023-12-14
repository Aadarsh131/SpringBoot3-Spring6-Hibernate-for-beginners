package com.challengefifteendays.basicapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		//by default @ComponentScan of the @SpringBootApplication only scan the main package (in our case- com.challengefifteendays.basicapp)
		//to make it scan custom pacakges we can specify it here
		scanBasePackages = {"com.differentPackage.util","com.challengefifteendays.basicapp"}
)
public class BasicappApplication {
	public static void main(String[] args) {
		SpringApplication.run(BasicappApplication.class, args);
	}

}
