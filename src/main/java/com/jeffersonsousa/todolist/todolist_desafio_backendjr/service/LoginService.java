package com.jeffersonsousa.todolist.todolist_desafio_backendjr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.entity.Login;
import com.jeffersonsousa.todolist.todolist_desafio_backendjr.repository.LoginRespository;

@Service
public class LoginService {

	@Autowired
	private LoginRespository loginRespository;
	
	public Login registerUser(Login login) {
		return loginRespository.save(login);
	}
	
	
	
}
