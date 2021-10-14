package com.jequiti;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "oracleGkoEntityManager",
		transactionManagerRef = "oracleGkoTransactionManager",
		basePackages = "com.jequiti.plataforma.integracao.gko.repository"
)
public class OracleGkoConfig {
	
	/**
	 * Oracle dataSource definition
	 * 
	 * @return dataSource
	 */
	@Bean(name="gkoDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.oracle.gko.datasource")
	public DataSource oracleGkoDataSource(){
		return DataSourceBuilder
				.create()
				.build();
	}
	
	/**
	 * Entity manager definition.
	 * 
	 * @param builder an EntityManagerFactoryBuilder.
	 * @return LocalContainerEntityManagerFactoryBean.	 * 
	 */
	@Bean(name = "oracleGkoEntityManager")
	@Primary
	public LocalContainerEntityManagerFactoryBean oracleGkoEntityManagerFactory(EntityManagerFactoryBuilder builder){
		return builder
				.dataSource(oracleGkoDataSource())
				.properties(hibernateProperties())
				.packages("com.jequiti.plataforma.integracao.gko.entity")
				.persistenceUnit("oracleGkoPU")
				.build();
	}
	
	@Bean(name = "oracleGkoTransactionManager")
	@Primary
	public PlatformTransactionManager oracleGkoTransactionManager(@Qualifier("oracleGkoEntityManager") EntityManagerFactory entityManagerFactory){
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	private Map<String, Object> hibernateProperties() {

		Resource resource = new ClassPathResource("hibernate.properties");
		
		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
			return properties.entrySet().stream()
											.collect(Collectors.toMap(
														e -> e.getKey().toString(),
														e -> e.getValue())
													);
		} catch (IOException e) {
			return new HashMap<String, Object>();
		}
	}

}
