package com.jeffersonsousa.todolist.todolist_desafio_backendjr.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeffersonsousa.todolist.todolist_desafio_backendjr.entity.Login;

@Repository
public interface LoginRespository extends JpaRepository<Login, UUID>{

}
