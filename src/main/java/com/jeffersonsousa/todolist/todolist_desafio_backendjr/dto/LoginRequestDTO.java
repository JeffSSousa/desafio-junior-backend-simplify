package com.jeffersonsousa.todolist.todolist_desafio_backendjr.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
		@NotBlank(message = "Campo Obrigatorio")
		String name, 
		@NotBlank(message = "Campo Obrigatorio")
		String username, 
		@NotBlank(message = "Campo Obrigatorio")
		String password, 
		@NotBlank(message = "Campo Obrigatorio")
		String email
		) {

}
