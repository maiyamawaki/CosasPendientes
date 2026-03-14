package com.joy.cosaspendientes.dto.response;

public class TodoResponse {
	private String todoId;

	private String userId;

	private String contents;

	public TodoResponse() {}

	public String getTodoId() {
		return todoId;
	}

	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
