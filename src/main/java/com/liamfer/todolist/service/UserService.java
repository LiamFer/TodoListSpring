package com.liamfer.todolist.service;

import com.liamfer.todolist.domain.UserEntity;
import com.liamfer.todolist.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void save(UserEntity user){
        repository.save(user);
    }
}
