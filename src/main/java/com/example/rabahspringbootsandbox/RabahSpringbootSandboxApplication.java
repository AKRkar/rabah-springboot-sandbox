package com.example.rabahspringbootsandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class RabahSpringbootSandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabahSpringbootSandboxApplication.class, args);
    }

    @RequestMapping("/tasks")
    public String saveTask(String tasks){
        // write logic to store tasks into db
        return "Success";
    }

}
