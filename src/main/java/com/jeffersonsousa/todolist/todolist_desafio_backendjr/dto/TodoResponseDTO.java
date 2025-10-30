package com.jeffersonsousa.todolist.todolist_desafio_backendjr.dto;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.entity.Todo;

public record TodoResponseDTO(String name, String description, boolean completed, Integer priority) {
	
	public TodoResponseDTO(Todo todo) {
		this(
				todo.getName(), 
				todo.getDescription(), 
				todo.isCompleted(), 
				todo.getPriority());
	}
}
