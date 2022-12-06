package com.example.rabahspringbootsandbox;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@Log
public class RabahSpringbootSandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabahSpringbootSandboxApplication.class, args);
    }

    @GetMapping("/tasks")
    public String getTask(@RequestParam(value = "tasks" )int taskId){ // json
        log.info("GET Tasks received: " + taskId);
        // write logic to get task from db
        return "Success";
    }

    @PostMapping(value = "/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String abcTask(@RequestBody String tasksJsonArray){ // json
        log.info("POST Tasks received: " + tasksJsonArray);
        // write logic to store task in db
        return "Success";
    }
}
