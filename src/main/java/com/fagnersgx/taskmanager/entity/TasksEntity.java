package com.fagnersgx.taskmanager.entity;

import com.fagnersgx.taskmanager.entity.enums.TaskPriority;
import com.fagnersgx.taskmanager.entity.enums.TaskStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "TASKS")
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(nullable = false)
    private String taskTitle;

    @Column(nullable = false)
    private String taskDesk;

    @Column(nullable = false)
    private Date taskInicio;

    @Column(nullable = false)
    private Date taskFim;

    @Enumerated
    @Column(nullable = false)
    private TaskStatus status;

    @Enumerated
    @Column(nullable = false)
    private TaskPriority priority;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private UsuarioEntity usuarioEntity;

    public TasksEntity() { }

    public TasksEntity(Long taskId, String taskTitle, String taskDesk, Date taskInicio, Date taskFim, TaskStatus status, TaskPriority priority) {
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

    public Date getTaskInicio(LocalDateTime localDateTime) {
        return taskInicio;
    }

    public void setTaskInicio(Date taskInicio) {
        this.taskInicio = taskInicio;
    }

    public Date getTaskFim() {
        return taskFim;
    }

    public void setTaskFim(Date taskFim) {
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

    public LocalDateTime dataHora() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(ldt.format(formatado));
    }
}
