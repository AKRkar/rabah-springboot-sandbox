package com.example.rabahspringbootsandbox;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@SpringBootApplication
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
@Log
public class RabahSpringbootSandboxApplication {
    public RabahSpringbootSandboxApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // in app.properties spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
    // @EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
    public class MyConfiguration { }

    public static void main(String[] args) {
        SpringApplication.run(RabahSpringbootSandboxApplication.class, args);
    }

    @GetMapping("/task")
    public String getTask(@RequestParam(value = "tasks" )int taskId){ // json
        log.info("GET Tasks received: " + taskId);
        // write logic to get task from db
        return "Success - return specific task: " + taskId;
    }
    @GetMapping("/tasks")
    public List<Task>  getAllTasks(){ // json
        log.info("GET all Tasks");
        List<Task> rtn = new ArrayList<>();
        for (Map.Entry<Long, Task> entry : inMemTaskList.entrySet()) {
            rtn.add(entry.getValue());
        }
        return rtn;
    }

    @PostMapping(value = "/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveTaskList(@RequestBody List<Task> IncomingTaskList){ // json
        for(Task o : IncomingTaskList){
            log.info("POST Tasks received - id " + o.id + " : " + o.text);
            inMemTaskList.put(o.id, o);
            saveToDB(inMemTaskList);
        }

        printMem();

        // write logic to store task in db
        return "Success";
    }

    final DataSource dataSource;


    private void saveToDB(Map<Long, Task> inMemTaskList) { // TODO
        // insert into Tasks (title, notes) values ("task4", "bm do something"), ("task5", "bm do something");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        SimpleJdbcInsert
        jdbcTemplate.update("insert into Tasks values (?, ?, ?)  ", 2, "task", "bm do something from springboot");
    }

    private void printMem() {
        for (Map.Entry<Long, Task> entry : inMemTaskList.entrySet()) {
            Long key = entry.getKey();
            Task task = entry.getValue();
            log.info("Task: " + task.id + " - " + task.text);
        }
    }

    public Map<Long, Task> inMemTaskList = new HashMap<>();

    public static class Task{
        public Task(Long id, String text, Boolean done){
            this.id = id;
            this.text = text;
            this.done = done;
        }
        public Long id;
        public String text;
        public Boolean done;
    }

}
