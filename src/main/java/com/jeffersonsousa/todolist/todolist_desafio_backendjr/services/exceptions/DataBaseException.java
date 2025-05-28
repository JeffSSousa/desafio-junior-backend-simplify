package com.jeffersonsousa.todolist.todolist_desafio_backendjr.services.exceptions;

public class DataBaseException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DataBaseException(String msg) {
		super(msg);
	}
	
}
