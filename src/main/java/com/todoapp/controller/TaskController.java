package com.todoapp.controller;

import com.todoapp.model.Task;
import com.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {this.taskService = taskService;}

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    //List completed tasks
    @GetMapping("/completed")
    public List<Task> getCompletedTasks(){
        return taskService.findByCompleted();
    }

    //List tasks due today
    @GetMapping("/due-today")
    public List<Task> getTasksDueToday(){
        return taskService.findDueToday();
    }

    //Get task by ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.findById(id);
    }

    //Create new Task
    @PostMapping
    public Task createTask(@RequestBody Task task){
       return taskService.save(task);
    }
    //Update an existing Task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        Task existingTask = taskService.findById(id);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setCompleted(task.getCompleted());
        existingTask.setDueDate(task.getDueDate());
        return taskService.save(existingTask);
    }

    //Delete task by ID
    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Long id){
        taskService.delete(id);
    }
}
