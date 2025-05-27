package com.jeffersonsousa.todolist.todolist_desafio_backendjr.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.entities.Todo;
import com.jeffersonsousa.todolist.todolist_desafio_backendjr.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoResource {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping
    public ResponseEntity<List<Todo>> findAll(){
    	List <Todo> list = todoService.findAll();
    	
    	return ResponseEntity.ok().body(list);
    }

	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Long id){
		Todo obj = todoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//insert
	
	//delete
	
	//update

}
