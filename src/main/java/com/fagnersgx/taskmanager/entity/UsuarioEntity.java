package com.fagnersgx.taskmanager.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USUARIO")
public class UsuarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "taskId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TasksEntity> tasksLists = new ArrayList<>();

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long usuarioId, String username, String email, String senha) {
        this.usuarioId = usuarioId;
        this.username = username;
        this.email = email;
        this.senha = senha;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<TasksEntity> getTasksLists() {
        return tasksLists;
    }

    public void setTasksLists(List<TasksEntity> tasksLists) {
        this.tasksLists = tasksLists;
    }
}
