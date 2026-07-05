package com.fagnersgx.taskmanager.controller;

import com.fagnersgx.taskmanager.entity.TasksEntity;
import com.fagnersgx.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path="/addTask")
    public TasksEntity createTask(@RequestBody TasksEntity novaTasksEntity) {
        TasksEntity novoTask = taskService.salvarTask(novaTasksEntity);
        return novoTask;
    }
}
