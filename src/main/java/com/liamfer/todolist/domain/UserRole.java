package com.liamfer.todolist.domain;

public enum UserRole {
    ADMIN("admin"),
    USER("user");
    public String role;
    UserRole(String role){this.role=role;}
    public String getRole(){return role;}
}
