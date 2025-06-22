package com.liamfer.todolist.controller;

import com.liamfer.todolist.domain.TokenResponseDTO;
import com.liamfer.todolist.domain.UserDTO;
import com.liamfer.todolist.domain.UserEntity;
import com.liamfer.todolist.infra.security.TokenService;
import com.liamfer.todolist.service.AuthorizationService;
import com.liamfer.todolist.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    private UserService service;
    private AuthenticationManager authenticationManager;
    private AuthorizationService authorizationService;
    private TokenService tokenService;

    public UserController(UserService service, AuthenticationManager authenticationManager, AuthorizationService authorizationService, TokenService tokenService) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.authorizationService = authorizationService;
        this.tokenService = tokenService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("adokqwkoqwd");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(),data.password());
        try{
            var auth = this.authenticationManager.authenticate(usernamePassword);
            String token = tokenService.generateToken((UserEntity) auth.getPrincipal());
            return ResponseEntity.status(HttpStatus.OK).body(new TokenResponseDTO(token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody @Valid UserDTO user){
        Optional<UserEntity> newUser = authorizationService.registerUser(user);
        if(newUser.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser.get());
    }

}
