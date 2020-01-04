package com.vebinar.garbage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
////
@ComponentScan(basePackages = {"ru.library.service", "ru.library.dao", "ru.library.config"})
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres?useSll=false");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }
}
