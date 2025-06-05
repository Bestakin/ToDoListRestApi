package com.todoapp.service;

import com.todoapp.model.Task;
import com.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findByCompleted() {
        return taskRepository.findByCompleted(true);
    }

    @Override
    public List<Task> findDueToday(){
        return taskRepository.findByDueDate(LocalDate.now());
    }

    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task save(Task task){
        return taskRepository.save(task);
    }
    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }
}
