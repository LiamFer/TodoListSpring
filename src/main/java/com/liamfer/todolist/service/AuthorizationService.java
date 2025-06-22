package com.liamfer.todolist.service;

import com.liamfer.todolist.domain.UserDTO;
import com.liamfer.todolist.domain.UserEntity;
import com.liamfer.todolist.domain.UserRole;
import com.liamfer.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizationService implements UserDetailsService {
    @Autowired
    UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email);
    }

    public Optional<UserEntity> registerUser(UserDTO user){
        if(repository.findByEmail(user.email()) != null) return Optional.empty();
        String hashedPassword = passwordEncoder.encode(user.password());
        return Optional.of(repository.save(new UserEntity(user.name(),user.email(), hashedPassword, UserRole.USER)));
    }
}
