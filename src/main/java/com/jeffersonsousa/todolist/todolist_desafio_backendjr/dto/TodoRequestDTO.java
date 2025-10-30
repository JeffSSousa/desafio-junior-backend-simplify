package com.jeffersonsousa.todolist.todolist_desafio_backendjr.dto;

import jakarta.validation.constraints.NotBlank;

public record TodoRequestDTO(
		@NotBlank(message = "Campo Obrigatorio")
		String name,
		@NotBlank(message = "Campo Obrigatorio")
		String description,
		boolean completed,
		Integer priority
		) {

}
