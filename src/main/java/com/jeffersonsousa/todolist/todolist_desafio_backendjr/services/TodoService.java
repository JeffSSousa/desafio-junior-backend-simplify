package com.jeffersonsousa.todolist.todolist_desafio_backendjr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.entities.Todo;
import com.jeffersonsousa.todolist.todolist_desafio_backendjr.repositories.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public List<Todo> findAll(){
		Sort sort = Sort.by(Direction.DESC, "priority")
				    .and(Sort.by(Direction.ASC, "id"));
		return todoRepository.findAll(sort);
	}
	
	public Todo findById(Long id) {
		Optional<Todo> obj = todoRepository.findById(id);
		return obj.get();
	}
	
	public Todo insert(Todo todo){
		return todoRepository.save(todo);
	}
	
	public void delete(Long id){
		todoRepository.deleteById(id);
	}
	
	public Todo update (Long id, Todo todo){
		Todo entity = todoRepository.getReferenceById(id);
		updateDate(entity, todo);
		return todoRepository.save(entity);
	}

	private void updateDate(Todo entity, Todo todo) {
		entity.setName(todo.getName());
		entity.setDescription(todo.getDescription());
		entity.setCompleted(todo.isCompleted());
		entity.setPriority(todo.getPriority());
	}

}
