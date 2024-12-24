package com.example.todolist;

import org.springframework.stereotype.Service;
import com.example.todolist.model.Task;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final Repo repo;

    public TaskService(Repo repo) {
        this.repo = repo;
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return repo.findById(id);
    }

    public Task createTask(Task task) {
        return repo.save(task);
    }

    public Task updateTask(Long id, Task task) {
        return repo.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(task.getTitle());
                    existingTask.setDescription(task.getDescription());
                    existingTask.setCompleted(task.isCompleted());
                    return repo.save(existingTask);
                }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
}
