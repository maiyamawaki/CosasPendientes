package com.joy.cosaspendientes.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import com.joy.cosaspendientes.repository.TodoRepository;
import com.joy.cosaspendientes.security.CustomUserDetails;
import com.joy.cosaspendientes.dto.request.TodoCreateRequest;
import com.joy.cosaspendientes.dto.request.TodoUpdateRequest;
import com.joy.cosaspendientes.dto.response.TodoResponse;
import com.joy.cosaspendientes.entity.Todo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
	
	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	private Long getUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails user = (CustomUserDetails)authentication.getPrincipal();
		return user.getUserId();
	}

	private TodoResponse toDto(Todo todo){
		TodoResponse todoRes = new TodoResponse();
		todoRes.setTodoId(todo.getTodoId());
		todoRes.setUserId(todo.getUser().getUserId());
		todo.setContents(todo.getContents());
		return todoRes;
	}

	public List<TodoResponse> findTodoByUserId(){
		Long userId = getUserId();
		List<TodoResponse> todoList = todoRepository.findByUser_IdAndIsDeletedFalse(userId)
																		.stream()
																		.map(this::toDto)
																		.collect(Collectors.toList());
		return todoList;
	}

	public List<TodoResponse> createNew(TodoCreateRequest req) {
		Todo todo = new Todo();
		todo.setContents(req.getContents());
		todo.setDelFlg(false);
		todoRepository.save(todo);
		List<TodoResponse> todoList = findTodoByUserId();
		return todoList;
	}

	public List<TodoResponse> updateTodo(TodoUpdateRequest req) {
		Todo todo = findTodoById(req.getTodoId());
		todo.setContents(req.getContents());
		todoRepository.save(todo);
		List<TodoResponse> todoList = findTodoByUserId();
		return todoList;
	}

	public List<TodoResponse> deleteTodo(TodoUpdateRequest req) {
		Todo todo = findTodoById(req.getTodoId());
		todo.setDelFlg(true);
		todoRepository.save(todo);
		List<TodoResponse> todoList = findTodoByUserId();
		return todoList;
	}

	private Todo findTodoById(Long todoId) {
		Todo todo = todoRepository.findById(todoId).orElseThrow(()->new RuntimeException("not found"));
		return todo;
	}

}
