package com.liamfer.todolist.controller;

import com.liamfer.todolist.domain.AuthenticationDTO;
import com.liamfer.todolist.domain.UserEntity;
import com.liamfer.todolist.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class UserController {
    private UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("adokqwkoqwd");
    }

    @PostMapping("/login")
    public ResponseEntity<UserEntity> register(@RequestBody @Valid AuthenticationDTO data){

    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity user){
        System.out.println(user.toString());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(user));
    }

}
