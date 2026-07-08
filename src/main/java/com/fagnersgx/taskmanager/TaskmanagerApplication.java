package com.fagnersgx.taskmanager;

import com.fagnersgx.taskmanager.controller.UsuarioController;
import com.fagnersgx.taskmanager.dto.UserDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TaskmanagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(TaskmanagerApplication.class, args);


	}

}
