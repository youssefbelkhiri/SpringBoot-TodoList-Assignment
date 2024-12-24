package com.example.todolist;

import com.example.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Task, Long> {
}
