package com.ssafy.alcohol.model.dto;

public class boardLike {
	private int id;
	private String userId;
	private int type, boardId;
	public boardLike(int id, String userId, int type, int boardId) {
		super();
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.boardId = boardId;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	@Override
	public String toString() {
		return "boardLike [id=" + id + ", userId=" + userId + ", type=" + type + ", boardId=" + boardId + "]";
	}
	

}
