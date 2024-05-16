package com.ssafy.alcohol.model.dto;

public class Friend {
//	name VARCHAR(20) NOT NULL,
//	sex BOOLEAN NOT NULL,
//	age INT NOT NULL,
//	kindOf VARCHAR(20),
//	region VARCHAR(20) NOT NULL,
//	intro TEXT NOT NULL
	private int id;
	private String userId;
	private String title;
	private String intro;
	private String region;
	private String kindOf;
	private String img;
	private int heart;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getKindOf() {
		return kindOf;
	}
	public void setKindOf(String kindOf) {
		this.kindOf = kindOf;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
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

	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
	@Override
	public String toString() {
		return "Friend [id=" + id + ", userId=" + userId + ", title=" + title + ", intro=" + intro + ", region="
				+ region + ", kindOf=" + kindOf + ", img=" + img + ", like=" + heart + "]";
	}
	public Friend(int id, String userId, String title, String intro, String region, String kindOf, String img,
			int heart) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.intro = intro;
		this.region = region;
		this.kindOf = kindOf;
		this.img = img;
		this.heart = heart;
	}
	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
