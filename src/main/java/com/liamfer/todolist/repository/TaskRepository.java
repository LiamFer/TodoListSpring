package com.liamfer.todolist.repository;

import com.liamfer.todolist.domain.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
}
