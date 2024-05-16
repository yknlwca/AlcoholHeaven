package com.ssafy.alcohol.model.dto;

public class Notice {
	private int id;
	private String userId, content, title, password;
	public Notice(int id, String userId, String content, String title, String password) {
		super();
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.title = title;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", userId=" + userId + ", content=" + content + ", title=" + title + ", password="
				+ password + "]";
	}
	
	
}
