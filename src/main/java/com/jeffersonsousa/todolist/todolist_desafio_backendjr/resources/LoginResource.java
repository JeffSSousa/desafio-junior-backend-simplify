package com.jeffersonsousa.todolist.todolist_desafio_backendjr.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.dto.LoginRequestDTO;
import com.jeffersonsousa.todolist.todolist_desafio_backendjr.entity.Login;
import com.jeffersonsousa.todolist.todolist_desafio_backendjr.service.LoginService;

@RestController
@RequestMapping("/user")
public class LoginResource {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping
	public ResponseEntity<Void> registerUser(@RequestBody LoginRequestDTO dto){
		Login login = new Login(dto);
		loginService.registerUser(login);	
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
