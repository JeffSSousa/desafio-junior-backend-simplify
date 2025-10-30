package com.jeffersonsousa.todolist.todolist_desafio_backendjr.entity;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.dto.LoginRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Login")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID loginId;
	private String name;
	private String username;
	private String password;
	private String email;

	@OneToMany(mappedBy = "login")
	private List<Todo> todos ;
	
	public Login() {
	}

	public Login(LoginRequestDTO dto) {
		this.name = dto.name();
		this.username = dto.username();
		this.password = dto.password();
		this.email = dto.email();
	}
	
	public Login(UUID loginId, String name, String username, String password, String email, List<Todo> todos) {
		this.loginId = loginId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.todos = todos;
	}
	

	public UUID getLoginId() {
		return loginId;
	}

	public void setLoginId(UUID loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(loginId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return Objects.equals(loginId, other.loginId);
	}
	
}
