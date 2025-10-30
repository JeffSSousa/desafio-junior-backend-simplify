package com.jeffersonsousa.todolist.todolist_desafio_backendjr.exception;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object obj) {
		
		super("Resource not found. Id " + obj);
	}
}
