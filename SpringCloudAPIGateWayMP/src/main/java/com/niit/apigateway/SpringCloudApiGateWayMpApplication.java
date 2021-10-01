package com.niit.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudApiGateWayMpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApiGateWayMpApplication.class, args);
	}

}
