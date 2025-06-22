package com.liamfer.todolist.controller;

import com.liamfer.todolist.domain.TaskDTO;
import com.liamfer.todolist.domain.TaskEntity;
import com.liamfer.todolist.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TaskController {
    private TaskService service;
    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<TaskDTO>> getTasks(@AuthenticationPrincipal UserDetails user, Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserTasks(user,pageable));
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody @Valid TaskDTO task, @AuthenticationPrincipal UserDetails user){
        TaskDTO createdTask = service.createTask(task,user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody @Valid TaskDTO task,
                                              @AuthenticationPrincipal UserDetails user,
                                              @PathVariable("id") Long id){
        TaskDTO editedTask = service.updateTask(id,task,user);
        return ResponseEntity.status(HttpStatus.OK).body(editedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(
            @AuthenticationPrincipal UserDetails user,
            @PathVariable("id") Long id
    ){
        service.deleteTask(id,user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
