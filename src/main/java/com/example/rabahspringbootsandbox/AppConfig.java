package com.example.rabahspringbootsandbox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class AppConfig {

        @Bean
        public DataSource mysqlDataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

            dataSource.setUrl("jdbc:mysql://localhost:3306/react_app");
            dataSource.setUsername("abd");
            dataSource.setPassword("bassam");
            try {
                System.out.println(dataSource.getConnection() != null ? "Good DB Connection" : "Failed DB Connection");
            } catch (SQLException e) {
                throw new RuntimeException(e); // stop tomcat initialization
            }
            return dataSource;
        }
}
