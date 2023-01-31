package com.noken.quidditchbe.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
public class QDbConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    public HikariConfig dataSourceProperties() {
        return new HikariConfig();
    }

    @Primary
    @Bean(name = "dataSource")
    public HikariDataSource dataSource() {
        return new HikariDataSource(dataSourceProperties());
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.noken.quidditchbe")
                .persistenceUnit("qbe")
                .build();
    }

}
