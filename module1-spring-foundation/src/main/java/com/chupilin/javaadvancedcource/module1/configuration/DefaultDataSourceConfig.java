package com.chupilin.javaadvancedcource.module1.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Profile("DEV")
@Configuration
public class DefaultDataSourceConfig {

    @Bean
    public DataSource defaultDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:test;DB_CLOSE_ON_EXIT=FALSE")
                .username("SA")
                .password("")
                .build();
    }

}
