package com.joy.cosaspendientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joy.cosaspendientes.entity.Todo;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	List<Todo> findByUser_UserIdAndDelFlgFalse(Long userId);
}
