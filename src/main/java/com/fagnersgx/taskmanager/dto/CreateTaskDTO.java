package com.fagnersgx.taskmanager.dto;

import com.fagnersgx.taskmanager.entity.enums.TaskPriority;
import com.fagnersgx.taskmanager.entity.enums.TaskStatus;

public record CreateTaskDTO(
        String taskTitle,
        String taskDesk,
        TaskStatus status,
        TaskPriority priority) {
}
