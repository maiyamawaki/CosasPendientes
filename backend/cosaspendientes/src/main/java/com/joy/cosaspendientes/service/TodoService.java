package com.joy.cosaspendientes.service;

import org.springframework.stereotype.Service;

import com.joy.cosaspendientes.repository.TodoRepository;
import com.joy.cosaspendientes.dto.request.TodoCreateRequest;
import com.joy.cosaspendientes.dto.request.TodoUpdateRequest;
import com.joy.cosaspendientes.dto.response.TodoResponse;
import com.joy.cosaspendientes.entity.Todo;


@Service
public class TodoService {
	
	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	private TodoResponse toDto(Todo todo){
		TodoResponse todoRes = new TodoResponse();
		todoRes.setTodoId(todo.getTodoId());
		todoRes.setUserId(todo.getUser().getUserId());
		todo.setContents(todo.getContents());
		return todoRes;
	}

	public TodoResponse getTodoById(Long todoId){
		return toDto(findUser(todoId));
	}

	private Todo findUser(Long todoId){
		Todo todo = todoRepository.findById(todoId).orElseThrow(()->new RuntimeException("not found"));
		return todo;
	}
}
