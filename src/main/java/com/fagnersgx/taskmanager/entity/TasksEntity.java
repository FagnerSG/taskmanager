package com.fagnersgx.taskmanager.entity;

import com.fagnersgx.taskmanager.entity.enums.TaskPriority;
import com.fagnersgx.taskmanager.entity.enums.TaskStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "TASKS")
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(nullable = false)
    private String taskTitle;

    @Column(nullable = false)
    private String taskDesk;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime taskInicio;

    @Column(nullable = true)
    private LocalDateTime taskFim;

    @Enumerated(EnumType.STRING)
    @Column()
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column()
    private TaskPriority priority;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private UsuarioEntity usuarioEntity;

    public TasksEntity() { }

    public TasksEntity(Long taskId, String taskTitle, String taskDesk, LocalDateTime taskInicio, LocalDateTime taskFim, TaskStatus status, TaskPriority priority) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskDesk = taskDesk;
        this.taskInicio = taskInicio;
        this.taskFim = taskFim;
        this.status = status;
        this.priority = priority;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long id) {
        this.taskId = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDesk() {
        return taskDesk;
    }

    public void setTaskDesk(String taskDesk) {
        this.taskDesk = taskDesk;
    }

    public LocalDateTime getTaskInicio(LocalDateTime localDateTime) {
        return taskInicio;
    }

    public void setTaskInicio(LocalDateTime taskInicio) {
        this.taskInicio = taskInicio;
    }

    public LocalDateTime getTaskFim() {
        return taskFim;
    }

    public void setTaskFim(LocalDateTime taskFim) {
        this.taskFim = taskFim;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

}
