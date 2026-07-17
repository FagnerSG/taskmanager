package com.fagnersgx.taskmanager.service;

import com.fagnersgx.taskmanager.entity.TasksEntity;
import com.fagnersgx.taskmanager.entity.UsuarioEntity;
import com.fagnersgx.taskmanager.entity.enums.TaskStatus;
import com.fagnersgx.taskmanager.repository.TaskRepository;
import com.fagnersgx.taskmanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public TaskService(TaskRepository taskRepository,
                       UsuarioRepository usuarioRepository) {
        this.taskRepository = taskRepository;
        this.usuarioRepository = usuarioRepository;
    }

    //criar tratamento de excessão e erro para evitar a criação de task sem titulo
    public TasksEntity salvarTask(TasksEntity createTask, Long usuarioId) {

        UsuarioEntity usuarioEntity = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        if (createTask.getTaskTitle() == null || createTask.getTaskTitle().isBlank()) {
            throw new IllegalArgumentException("O título da tarefa é obrigatório.");
        }

        if (createTask.getTaskDesk() == null || createTask.getTaskDesk().isBlank()) {
            throw new IllegalArgumentException("A descrição da tarefa é obrigatória.");
        }

        createTask.taskUsuarioEntity(usuarioEntity);

        return taskRepository.save(createTask);
    }

    public List<TasksEntity> listarTodasTask() {
        return taskRepository.findAll();
    }

    public TasksEntity atualizarTask(Long id, TasksEntity taskAtualizada) {
        TasksEntity atualizarTaskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada."));

        if (taskAtualizada.getTaskTitle() == null || taskAtualizada.getTaskTitle().isBlank()) {
            throw new IllegalArgumentException("Título é obrigatório.");
        }
        if (taskAtualizada.getTaskDesk() == null || taskAtualizada.getTaskDesk().isBlank()) {
            throw new IllegalArgumentException("Descrição é obrigatória.");
        }

        atualizarTaskEntity.setTaskTitle(taskAtualizada.getTaskTitle());
        atualizarTaskEntity.setTaskDesk(taskAtualizada.getTaskDesk());
        atualizarTaskEntity.setStatus(taskAtualizada.getStatus());
        if(atualizarTaskEntity.getStatus() == TaskStatus.valueOf("CONCLUIDA")) {
            atualizarTaskEntity.setTaskFim(LocalDateTime.now().withNano(0));
        }
        atualizarTaskEntity.setPriority(taskAtualizada.getPriority());

        return taskRepository.save(atualizarTaskEntity);
    }

    public void deletarTask(Long id) {
        TasksEntity task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada."));

        taskRepository.delete(task);
    }

}
