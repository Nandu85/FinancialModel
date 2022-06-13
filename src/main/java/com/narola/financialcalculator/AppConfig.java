package com.narola.financialcalculator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan(basePackages = "com.narola.financialcalculator")
@EnableWebMvc
public class AppConfig {

}