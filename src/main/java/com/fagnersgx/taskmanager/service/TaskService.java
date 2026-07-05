package com.fagnersgx.taskmanager.service;

import com.fagnersgx.taskmanager.entity.TasksEntity;
import com.fagnersgx.taskmanager.entity.UsuarioEntity;
import com.fagnersgx.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //criar tratamento de excessão e erro para evitar a criação de task sem titulo
    public TasksEntity salvarTask(TasksEntity createTask){
        TasksEntity salvarTask = new TasksEntity();
        if (createTask.getTaskTitle()  == null || createTask.getTaskDesk() == null) {
            salvarTask.setTaskTitle(createTask.getTaskTitle());
            salvarTask.setTaskDesk(createTask.getTaskDesk());
        }
        return taskRepository.save(salvarTask);
    }

    public List<TasksEntity> listarTodasTask() {
        return taskRepository.findAll();
    }
}
