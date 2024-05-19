package com.ssafy.alcohol.model.dto;

public class Alcohol {
//	name VARCHAR(20) NOT NULL,
//	detailRegion VARCHAR(20) ,
//	kindOf VARCHAR(20),
//	content TEXT,
//	region VARCHAR(20) NOT NULL
	private int id;
	private String userId;
	private String name;
	private String detailRegion;
	private String kindOf;
	private String content;
	private String region;
	private float weight;
	private String img;
	private String orgImg;
	private int heart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetailRegion() {
		return detailRegion;
	}

	public void setDetailRegion(String detailRegion) {
		this.detailRegion = detailRegion;
	}

	public String getKindOf() {
		return kindOf;
	}

	public void setKindOf(String kindOf) {
		this.kindOf = kindOf;
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

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
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

	public int getHeart() {
		return heart;
	}

	public void setHeart(int heart) {
		this.heart = heart;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Alcohol [id=" + id + ", userId=" + userId + ", name=" + name + ", detailRegion=" + detailRegion
				+ ", kindOf=" + kindOf + ", content=" + content + ", region=" + region + ", weight=" + weight + ", img="
				+ img + ", orgImg=" + orgImg + ", heart=" + heart + "]";
	}

	public Alcohol(int id, String userId, String name, String detailRegion, String kindOf, String content,
			String region, float weight, String img, String orgImg, int heart) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.detailRegion = detailRegion;
		this.kindOf = kindOf;
		this.content = content;
		this.region = region;
		this.weight = weight;
		this.img = img;
		this.orgImg = orgImg;
		this.heart = heart;
	}

	public Alcohol() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
