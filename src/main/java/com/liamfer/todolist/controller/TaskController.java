package com.liamfer.todolist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TaskController {

    @PostMapping
    public ResponseEntity<?> createTask(){
        return ResponseEntity.ok().build();
    }
}
