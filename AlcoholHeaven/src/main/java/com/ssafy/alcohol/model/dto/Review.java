package com.ssafy.alcohol.model.dto;

public class Review {
	private int reviewId, id, type;
	private String writer, content;
	public Review(int reviewId, int id, String writer, String content, int type) {
		super();
		this.reviewId = reviewId;
		this.id = id;
		this.writer = writer;
		this.content = content;
		this.type = type;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", id=" + id + ", writer=" + writer + ", content=" + content + "]";
	}
	
	

}
