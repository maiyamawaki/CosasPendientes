package com.joy.cosaspendientes.dto.response;

public class TodoResponse {
	private Long todoId;

	private Long userId;

	private String contents;

	public TodoResponse() {}

	public Long getTodoId() {
		return todoId;
	}

	public void setTodoId(Long todoId) {
		this.todoId = todoId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
