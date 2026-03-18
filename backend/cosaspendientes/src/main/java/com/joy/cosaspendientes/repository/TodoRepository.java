package com.joy.cosaspendientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joy.cosaspendientes.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	
}
