package com.jeffersonsousa.todolist.todolist_desafio_backendjr.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.dto.TodoRequestDTO;
import com.jeffersonsousa.todolist.todolist_desafio_backendjr.dto.TodoResponseDTO;
import com.jeffersonsousa.todolist.todolist_desafio_backendjr.entity.Todo;
import com.jeffersonsousa.todolist.todolist_desafio_backendjr.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoResource {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping
    public ResponseEntity<List<TodoResponseDTO>> findAll(){
    	List <TodoResponseDTO> list = todoService.findAll().stream().map(TodoResponseDTO::new).toList();
    	
    	return ResponseEntity.ok().body(list);
    }

	@GetMapping(value = "/{id}")
	public ResponseEntity<TodoResponseDTO> findById(@PathVariable Long id){
		Todo todo = todoService.findById(id);
		TodoResponseDTO dto = new TodoResponseDTO(todo);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody TodoRequestDTO dto){
		Todo todo = new Todo(dto);
		todoService.insert(todo);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		todoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
