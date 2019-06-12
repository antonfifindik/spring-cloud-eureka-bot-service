package com.antonfifindik.botservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
public class Config {

    /**
     * The data source for storing all objects.
     *
     * @return data source
     */
    @Bean
    @Profile("development")
    @ConfigurationProperties(prefix = "application.datasource")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

}
