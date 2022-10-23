package com.basic.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration(proxyBeanMethods = false)
@PropertySources({
        @PropertySource(value = "classpath:application-prod.yml",factory = YamlPropertySourceFactory.class)    ,
        @PropertySource(value = "classpath:application-stage.yml",factory = YamlPropertySourceFactory.class)
})
public class HikariCpConfig extends HikariConfig {

    @Profile("dev")
    @Bean
    @ConfigurationProperties("dev.datasource")
    public HikariDataSource devDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Profile("stage")
    @Bean
    @ConfigurationProperties("stage.datasource")
    public HikariDataSource stageDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Profile("prod")
    @Bean
    @ConfigurationProperties("prod.datasource")
    public HikariDataSource prodDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }




}
