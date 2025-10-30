package com.jeffersonsousa.todolist.todolist_desafio_backendjr.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginViewController {

	@GetMapping("/login")
	public String pageLogin() {
		return "login";
	}
	
}
