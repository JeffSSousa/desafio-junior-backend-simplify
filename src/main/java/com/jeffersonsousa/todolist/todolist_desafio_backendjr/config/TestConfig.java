package com.jeffersonsousa.todolist.todolist_desafio_backendjr.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.entities.Todo;
import com.jeffersonsousa.todolist.todolist_desafio_backendjr.repositories.TodoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	TodoRepository todoRepository;
	
	@Override
	public void run(String... args) {
		
		Todo l1 = new Todo("Test 1", "Desc test 1", false, 1);
		Todo l2 = new Todo("Test 2", "Desc test 2", true, 3);
		Todo l3 = new Todo("Test 3", "Desc test 3", false, 2);
		
		todoRepository.saveAll(Arrays.asList(l1,l2,l3));
		
		
	}
}
