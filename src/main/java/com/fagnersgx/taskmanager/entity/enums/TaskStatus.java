package com.fagnersgx.taskmanager.entity.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum TaskStatus {
    AGUARDANDO_INICIO,
    EXUCUTANDO,
    CONCLUIDO;
}
