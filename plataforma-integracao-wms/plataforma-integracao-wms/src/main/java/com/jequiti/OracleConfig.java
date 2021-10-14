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
		entityManagerFactoryRef = "oracleEntityManager",
		transactionManagerRef = "oracleTransactionManager",
		basePackages = "com.jequiti.plataforma.integracao.wms.ebs.repository"
)
public class OracleConfig {
	
	/**
	 * Oracle dataSource definition
	 * 
	 * @return dataSource
	 */
	@Bean(name="dataSource")
	@ConfigurationProperties(prefix = "spring.oracle.datasource")
	public DataSource oracleDataSource(){
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
	@Bean(name = "oracleEntityManager")
	public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(EntityManagerFactoryBuilder builder){
		return builder
				.dataSource(oracleDataSource())
				.properties(hibernateProperties())
				.packages("com.jequiti.plataforma.integracao.wms.ebs.entity")
				.persistenceUnit("oraclePU")
				.build();
	}
	
	@Bean(name = "oracleTransactionManager")
	public PlatformTransactionManager oracleTransactionManager(@Qualifier("oracleEntityManager") EntityManagerFactory entityManagerFactory){
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
