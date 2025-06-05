package com.todoapp.service;

import com.todoapp.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findByCompleted();
    List<Task> findDueToday();
    List<Task> findAll();
    Task save(Task task);
    Task findById(Long id);
    void delete(Long id);
}
