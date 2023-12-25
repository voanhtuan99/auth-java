package com.example.springmongo.controller;

import com.example.springmongo.model.Task;

import com.example.springmongo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping()
    public Task createTask (@RequestBody Task task) {
        System.out.println(task);
        return taskService.createNewTask(task);
    }

    @GetMapping()
    public List<Task> getAll () {
        return taskService.retrieveTask();
    }

    @GetMapping("/{id}")
    public Optional<Task> getByTaskId (@PathVariable Long id) {
        System.out.println(id);
        return taskService.getById(id);
    }
}
