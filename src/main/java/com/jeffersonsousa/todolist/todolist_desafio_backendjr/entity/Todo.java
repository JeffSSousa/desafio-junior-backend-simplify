package com.jeffersonsousa.todolist.todolist_desafio_backendjr.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_todolist")
public class Todo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long todoId;
	private String name;
	private String description;
	private boolean completed;
	private Integer priority;
	
	@ManyToOne
	@JoinColumn(name = "login_id")
	private Login login;
	
	
	public Todo() {
	}

	
	public Todo(String name, String description, boolean completed, Integer priority, Login login) {
		this.name = name;
		this.description = description;
		this.completed = completed;
		this.priority = priority;
		this.login = login;
	}



	public Long getTodoId() {
		return todoId;
	}


	public void setTodoId(Long todoId) {
		this.todoId = todoId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	@Override
	public int hashCode() {
		return Objects.hash(todoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return Objects.equals(todoId, other.todoId);
	}
	
	

}
