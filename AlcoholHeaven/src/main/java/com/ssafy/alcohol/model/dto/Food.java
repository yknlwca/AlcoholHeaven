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
	private String kindOf;
	private String heart;
	private String img;
	private String orgImg;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getKindOf() {
		return kindOf;
	}

	public void setKindOf(String kindOf) {
		this.kindOf = kindOf;
	}

	public String getHeart() {
		return heart;
	}

	public void setHeart(String heart) {
		this.heart = heart;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOrgImg() {
		return orgImg;
	}

	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", userId=" + userId + ", menu=" + menu + ", content=" + content + ", title=" + title
				+ ", region=" + region + ", kindOf=" + kindOf + ", heart=" + heart + ", img=" + img + ", orgImg="
				+ orgImg + "]";
	}

	public Food(int id, String userId, String menu, String content, String title, String region, String kindOf,
			String heart, String img, String orgImg) {
		super();
		this.id = id;
		this.userId = userId;
		this.menu = menu;
		this.content = content;
		this.title = title;
		this.region = region;
		this.kindOf = kindOf;
		this.heart = heart;
		this.img = img;
		this.orgImg = orgImg;
	}

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

}
