package com.example.springmongo.service;

import com.example.springmongo.model.Task;

import com.example.springmongo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;



    public Task createNewTask (Task task) {
        String uniqueID = UUID.randomUUID().toString();
        task.setTaskId(uniqueID);
        System.out.println(task);
        return taskRepository.save(task);
    }

    public List<Task> retrieveTask () {
        return taskRepository.findAll();
    }

    public Optional<Task> getById (Long id) {
        String parseId = String.valueOf(id);
        System.out.println(taskRepository.findById(parseId));
        return taskRepository.findById(parseId);
    }
}
