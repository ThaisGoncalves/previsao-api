package com.jequiti;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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

 

/**
 * Configuração do dataSource referente ao banco SQL.
 * 
 * @author hprestes 01/2021
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.jequiti.plataforma.integracao.wms.repository", 
							entityManagerFactoryRef = "sqlEntityManager",	
							transactionManagerRef = "sqlTransactionManager")
public class SQLDataSourceConfig {

 

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.sql.datasource")
    public DataSource sqlDataSource() {
        return DataSourceBuilder.create().build();
    }

 

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean sqlEntityManager(EntityManagerFactoryBuilder builder,
            @Qualifier("sqlDataSource") DataSource dataSource) {
    	return builder
				.dataSource(sqlDataSource())
				.properties(hibernateProperties())
				.packages("com.jequiti.plataforma.integracao.wms.entity")
				.persistenceUnit("mssqlPU")
				.build();
	}
 
    
    @Bean(name = "sqlTransactionManager")
	public PlatformTransactionManager sqlTransactionManager(@Qualifier("sqlEntityManager") EntityManagerFactory entityManagerFactory){
		return new JpaTransactionManager(entityManagerFactory);
	}
    
    
    
    private Map<String, Object> hibernateProperties() {

		Resource resource = new ClassPathResource("hibernate.properties");
		
		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			properties.put("hibernate.dialect","org.hibernate.dialect.SQLServer2012Dialect");
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