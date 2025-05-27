package com.jeffersonsousa.todolist.todolist_desafio_backendjr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	

}
