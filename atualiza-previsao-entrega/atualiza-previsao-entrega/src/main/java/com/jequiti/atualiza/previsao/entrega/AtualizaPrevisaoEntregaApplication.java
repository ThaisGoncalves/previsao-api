package com.jequiti.atualiza.previsao.entrega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@PropertySource("classpath:parametros.properties")
@PropertySource("classpath:requisicao.properties")
@EnableScheduling
public class AtualizaPrevisaoEntregaApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AtualizaPrevisaoEntregaApplication.class, args);
	}

	@Bean( name = "propertyConfigurer" )
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
	PropertySourcesPlaceholderConfigurer configurer =
	new PropertySourcesPlaceholderConfigurer();



	return configurer;
	}
}
