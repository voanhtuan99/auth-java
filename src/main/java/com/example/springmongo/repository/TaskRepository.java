package com.example.springmongo.repository;

import com.example.springmongo.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}
