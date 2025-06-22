package com.liamfer.todolist.service;

import com.liamfer.todolist.domain.TaskDTO;
import com.liamfer.todolist.domain.TaskEntity;
import com.liamfer.todolist.domain.UserEntity;
import com.liamfer.todolist.repository.TaskRepository;
import com.liamfer.todolist.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskDTO createTask(TaskDTO task, UserDetails user){
        UserEntity userData = userRepository.findByEmail(user.getUsername());
        TaskEntity createdTask = taskRepository.save(new TaskEntity(task.title(),task.description(),userData));
        return new TaskDTO(createdTask.id, createdTask.title, createdTask.description);
    }
}
