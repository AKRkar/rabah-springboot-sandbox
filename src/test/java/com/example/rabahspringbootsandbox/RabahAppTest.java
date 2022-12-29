package com.example.rabahspringbootsandbox;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

class RabahAppTest {
    @Test void Test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.example.rabahspringbootsandbox.AppConfig.class);
        DataSource ds = context.getBean(DataSource.class);
        try {
            System.out.println(ds.getConnection() == null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}