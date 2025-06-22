package com.liamfer.todolist.repository;

import com.liamfer.todolist.domain.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
    Page<TaskEntity> findAllByUserId(String id, Pageable page);
}
