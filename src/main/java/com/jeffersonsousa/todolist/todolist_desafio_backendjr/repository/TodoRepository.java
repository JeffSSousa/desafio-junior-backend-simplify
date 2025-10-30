package com.jeffersonsousa.todolist.todolist_desafio_backendjr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	

}
