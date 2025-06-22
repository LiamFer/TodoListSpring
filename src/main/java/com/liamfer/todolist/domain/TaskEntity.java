package com.liamfer.todolist.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tb_task")
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public String description;
    @ManyToOne
    @JoinColumn(name="user_id")
    public UserEntity user;

    public TaskEntity(String title,String description, UserEntity user){
        this.title = title;
        this.description = description;
        this.user = user;
    }
}
