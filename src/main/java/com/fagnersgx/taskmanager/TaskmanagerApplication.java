package com.fagnersgx.taskmanager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(info = @Info(
		title = "Task Swagger",
		version = "0.1",
		description = "API para gerenciar as Tasks"))
public class TaskmanagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(TaskmanagerApplication.class, args);


	}

}
