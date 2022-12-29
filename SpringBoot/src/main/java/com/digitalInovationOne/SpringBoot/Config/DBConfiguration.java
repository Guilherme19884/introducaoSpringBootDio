package com.digitalInovationOne.SpringBoot.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {

	private String driverClassName;
	private String url;
	private String password;
	
	@Profile("Dev")
	@Bean
	public String testDataBaseConnection() {
		System.out.println("DB Configuration for DEV - H2");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection to H2_Test";
	}
	
	@Profile("Prod")
	@Bean
	public String productionDataBaseConnection() {
		System.out.println("DB Configuration for Production - MYSQL");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection to MYSQL_PROD Produtction instance";
	}
}
