package com.angular.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


/**
 * @Autor Samuel.Guardado
 * @FechaCreacion 20/01/2015
 */
@Configuration
@ComponentScan("com.angular.spring.service")
@Import(MongoDBConfig.class)
public class ApplicationContext {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
