package com.example.rabahspringbootsandbox;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@Log
public class RabahSpringbootSandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabahSpringbootSandboxApplication.class, args);
    }

    @GetMapping("/tasks")
    public String getTaskList(@RequestParam(value = "tasks" )int taskId){ // json
        log.info("GET Tasks received: " + taskId);
        // write logic to get task from db
        return "Success - all tasks returned";
    }

    @PostMapping(value = "/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveTaskList(@RequestBody List<Task> IncomingTaskList){ // json
        for(Task o : IncomingTaskList){
            log.info("POST Tasks received - id " + o.id + " : " + o.text);
            inMemTaskList.put(o.id, o);
        }

        printMem();

        // write logic to store task in db
        return "Success";
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
