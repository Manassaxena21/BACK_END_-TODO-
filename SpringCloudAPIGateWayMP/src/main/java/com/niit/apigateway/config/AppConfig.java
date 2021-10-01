package com.niit.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/api/v1/**")//"/api/v1/**"
						.uri("http://localhost:8086/"))//"http://localhost:8090/"
				.route(p->p
						.path("/api/v2/**")//"/api/v2/**"
						.uri("http://localhost:8081/"))//"http://localhost:8085/"
				.route(p->p
						.path("/api/v2/**")//"/api/v2/**"
						.uri("http://localhost:8085/"))//"http://localhost:8085/"
				.route(p->p
						.path("/schedule/email")//"/schedule/email**"
						.uri("http://localhost:8080/"))//http://localhost:8080/schedule/email
				.build();
	}
	


}
