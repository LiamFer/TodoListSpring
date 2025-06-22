package com.liamfer.todolist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAll(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error");
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<?> handleForbidden(ResourceAccessException ex){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Forbidden");
    }
}