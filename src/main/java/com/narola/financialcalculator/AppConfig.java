package com.narola.financialcalculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan(basePackages = "com.narola.financialcalculator")
@PropertySource("classpath:config.properties")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer{

	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public DBConnection getDBConfig(@Value("${MYSQL_dbname}") String dbName, @Value("${MYSQL_dburl}") String dbUrl, @Value("${MYSQL_username}") String dbUser, @Value("${MYSQL_password}") String dbPass) {
		DBConnection dbConnection = new DBConnection(dbName,dbUrl,dbUser,dbPass);
		return dbConnection;
	}

}