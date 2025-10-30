package com.jeffersonsousa.todolist.todolist_desafio_backendjr.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.entity.Todo;
import com.jeffersonsousa.todolist.todolist_desafio_backendjr.service.TodoService;

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
	
	@PostMapping
	public ResponseEntity<Todo> insert(@RequestBody Todo todo){
		todo = todoService.insert(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getTodoId()).toUri();
		return ResponseEntity.created(uri).body(todo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Todo> delete(@PathVariable Long id){
		todoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Todo> update(@PathVariable Long id, @RequestBody Todo todo){
		todo = todoService.update(id, todo);
		return ResponseEntity.ok().body(todo);
	}

}
