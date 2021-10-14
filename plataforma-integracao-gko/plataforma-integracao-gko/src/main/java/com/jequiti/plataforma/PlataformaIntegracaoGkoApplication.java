package com.jequiti.plataforma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.jequiti"})
@Configuration
public class PlataformaIntegracaoGkoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlataformaIntegracaoGkoApplication.class, args);
	}

}

