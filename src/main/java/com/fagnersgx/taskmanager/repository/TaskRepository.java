package com.fagnersgx.taskmanager.repository;

import com.fagnersgx.taskmanager.entity.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TasksEntity, Long> {
}
