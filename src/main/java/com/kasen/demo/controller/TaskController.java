package com.kasen.demo.controller;

import com.kasen.demo.model.Task;
import com.kasen.demo.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")

public class TaskController {
    
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;

    }

    @GetMapping
    public List<Task> getAllTasks() {

        return taskRepository.findAll();

    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {

        return taskRepository.save(task);
    }

    @GetMapping("/{id}") 

    public Task getTaskById(@PathVariable Long id) {

            return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        }

    @PutMapping("/{id}") 
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {

        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());
        return taskRepository.save(task);

    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {

        taskRepository.deleteById(id);

    }

}
