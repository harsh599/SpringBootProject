package com.appdeveloperblog.app.ws.mobileappwsNew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackageClasses = UserController.class)

@ComponentScan({ "com.appsdeveloperblog.app.ws.mobileappws.ui.controller", "com.appdeveloperblog.app.ws.service.impl" }) // ,
																				// "com.appdeveloperblog.app.ws.service.impl"
//@EnableJpaRepositories(basePackages = "your repo packages here")
//@EntityScan(basePackages = "com.appdeveloperblog.app.ws.mobileappwsNew.io.entity")

public class MobileAppWsNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppWsNewApplication.class, args);
	}

}
