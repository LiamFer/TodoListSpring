package com.liamfer.todolist.service;

import com.liamfer.todolist.domain.TaskDTO;
import com.liamfer.todolist.domain.TaskEntity;
import com.liamfer.todolist.domain.UserEntity;
import com.liamfer.todolist.repository.TaskRepository;
import com.liamfer.todolist.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Page<TaskDTO> getUserTasks(UserDetails user, Pageable pageable){
        UserEntity userData = userRepository.findByEmail(user.getUsername());
        return taskRepository.findAllByUserId(userData.id,pageable).map(task -> new TaskDTO(task.id, task.title, task.description));
    }

    public TaskDTO createTask(TaskDTO task, UserDetails user){
        UserEntity userData = userRepository.findByEmail(user.getUsername());
        TaskEntity createdTask = taskRepository.save(new TaskEntity(task.title(),task.description(),userData));
        return new TaskDTO(createdTask.id, createdTask.title, createdTask.description);
    }

    public TaskDTO updateTask(Long id,TaskDTO task, UserDetails user){
        UserEntity userData = userRepository.findByEmail(user.getUsername());
        Optional<TaskEntity> taskData = taskRepository.findById(id);
        if(taskData.isPresent() && taskData.get().user.id.equals(userData.id)){
            TaskEntity editedTask = taskRepository.save(new TaskEntity(id,task.title(),task.description(),userData));
            return new TaskDTO(editedTask.id, editedTask.title, editedTask.description);
        }
        throw new ResourceAccessException("Task não pertence ao Usuário");
    }

    public void deleteTask(Long id,UserDetails user){
        UserEntity userData = userRepository.findByEmail(user.getUsername());
        Optional<TaskEntity> taskData = taskRepository.findById(id);
        if(taskData.isPresent() && taskData.get().user.id.equals(userData.id)){
            taskRepository.deleteById(id);
        } else {
            throw new ResourceAccessException("Task não pertence ao Usuário");
        }
    }
}
