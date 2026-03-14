package com.joy.cosaspendientes.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Todo {
	@Id
	private String todoId;

	private String userId;

	private String contents;

	private boolean delFlg;

	private LocalDateTime insTime;

	private LocalDateTime updTime;

	public Todo() {}

	public Todo(String userId, String contents) {
		this.userId = userId;
		this.contents = contents;
	}

	@PrePersist
	public void preTimeSet() {
		this.insTime = LocalDateTime.now();
		this.updTime = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdateTimeSet() {
		this.updTime = LocalDateTime.now();
	}

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

	public boolean isDelFlg() {
		return delFlg;
	}

	public void setDelFlg(boolean delFlg) {
		this.delFlg = delFlg;
	}

	public LocalDateTime getInsTime() {
		return insTime;
	}

	public void setInsTime(LocalDateTime insTime) {
		this.insTime = insTime;
	}

	public LocalDateTime getUpdTime() {
		return updTime;
	}

	public void setUpdTime(LocalDateTime updTime) {
		this.updTime = updTime;
	}
	
}
