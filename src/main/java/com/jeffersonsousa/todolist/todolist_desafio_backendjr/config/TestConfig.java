package com.jeffersonsousa.todolist.todolist_desafio_backendjr.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.entity.Todo;
import com.jeffersonsousa.todolist.todolist_desafio_backendjr.repository.TodoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	TodoRepository todoRepository;
	
	@Override
	public void run(String... args) {
		
		Todo example1 = new Todo("Back-end", "Estudar Spring Boot", false, 2);
		Todo example2 = new Todo("DevOps", "Fazer deploy no Heroku", true, 3);
		Todo example3 = new Todo("Testes", "Criar testes com JUnit", false, 1);
		
		todoRepository.saveAll(Arrays.asList(example1,example2,example3));
		
	}
}
