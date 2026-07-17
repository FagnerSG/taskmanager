package com.fagnersgx.taskmanager.controller;

import com.fagnersgx.taskmanager.dto.CreateTaskDTO;
import com.fagnersgx.taskmanager.entity.TasksEntity;
import com.fagnersgx.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path="/{usuarioId}/addTask")
    public ResponseEntity<TasksEntity> createTask(@RequestBody CreateTaskDTO dto,
                                                  @PathVariable Long usuarioId) {
        TasksEntity task = new TasksEntity();

        task.setTaskTitle(dto.taskTitle());
        task.setTaskDesk(dto.taskDesk());
        task.setStatus(dto.status());
        task.setPriority(dto.priority());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(taskService.salvarTask(task, usuarioId));
    }

    @GetMapping(path="/listTask")
    public ResponseEntity<List<TasksEntity>> getAllTask() {
        List<TasksEntity> listTask = taskService.listarTodasTask();
        return ResponseEntity.ok().body(listTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TasksEntity> atualizarTask(
            @PathVariable Long id,
            @RequestBody TasksEntity taskAtualizada) {

        TasksEntity task = taskService.atualizarTask(id, taskAtualizada);

        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTask(@PathVariable Long id) {

        taskService.deletarTask(id);

        return ResponseEntity.noContent().build();
    }

}
