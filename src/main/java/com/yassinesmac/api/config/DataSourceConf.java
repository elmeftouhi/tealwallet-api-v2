package com.yassinesmac.api.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConf {
    @Bean
    public DataSource mysqlConf(){
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.username("root");
        dataSourceBuilder.password("");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/tealwallet-db");
        return  dataSourceBuilder.build();
    }

    @Bean
    @Primary
    public DataSource h2Conf(){
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.url("jdbc:h2:mem:tealwallet-db");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();

    }
}
