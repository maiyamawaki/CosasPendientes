package com.joy.cosaspendientes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import com.joy.cosaspendientes.dto.request.TodoCreateRequest;
import com.joy.cosaspendientes.dto.request.TodoUpdateRequest;
import com.joy.cosaspendientes.dto.response.TodoResponse;
import com.joy.cosaspendientes.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
	public List<TodoResponse> findTodoByUserId() {
		return todoService.findTodoByUserId();
	}

	@GetMapping()
	public List<TodoResponse> creaateTodo(@RequestBody TodoCreateRequest req){
		return todoService.createNew(req);
	}

	@PostMapping("")
	public List<TodoResponse> updateTodo(@RequestBody TodoUpdateRequest req){
		return todoService.updateTodo(req);
	}

	@PostMapping("")
	public List<TodoResponse> deleteTodo(@RequestBody TodoUpdateRequest req){
		return todoService.deleteTodo(req);
	}

}
