package com.joy.cosaspendientes.dto.request;

public class TodoUpdateRequest {
	private Long todoId;

	private String contents;

	public TodoUpdateRequest() {}

	public Long getTodoId() {
		return todoId;
	}

	public void settodoId(Long todoId) {
		this.todoId = todoId;
	}
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
