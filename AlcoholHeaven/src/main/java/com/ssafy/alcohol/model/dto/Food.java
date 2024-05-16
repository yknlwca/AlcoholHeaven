package com.ssafy.alcohol.model.dto;

public class Food {
//	menu text NOT NULL,
//	kindOf VARCHAR(20) ,
//	content TEXT,
//	region VARCHAR(20) NOT NULL,
//	file TEXT
	private int id;
	private String userId;
	private String menu;
	private String content;
	private String title;
	private String region;
	private String img;
	private String heart;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	
	public String getHeart() {
		return heart;
	}
	public void setHeart(String heart) {
		this.heart = heart;
	}
	public Food(int id, String userId, String menu, String content, String title, String region, String img,
			String heart) {
		super();
		this.id = id;
		this.userId = userId;
		this.menu = menu;
		this.content = content;
		this.title = title;
		this.region = region;
		this.img = img;
		this.heart = heart;
	}
	
	public Food() {
		super();
	}
	
	@Override
	public String toString() {
		return "Food [id=" + id + ", userId=" + userId + ", menu=" + menu + ", content=" + content + ", title=" + title
				+ ", region=" + region + ", img=" + img + ", like=" + heart + "]";
	}
	
}
