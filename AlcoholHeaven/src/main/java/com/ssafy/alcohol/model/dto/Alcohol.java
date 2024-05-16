package com.ssafy.alcohol.model.dto;

public class Alcohol {
//	name VARCHAR(20) NOT NULL,
//	detailRegion VARCHAR(20) ,
//	kindOf VARCHAR(20),
//	content TEXT,
//	region VARCHAR(20) NOT NULL
	private int id;
	private String name;
	private String detailRegion;
	private String kindOf;
	private String content;
	private String region;
	private float weight;
	private String img;
	private int heart;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getHeart() {
		return heart;
	}

	public void setHeart(int heart) {
		this.heart = heart;
	}

	public Alcohol() {
		
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

	@Override
	public String toString() {
		return "Alcohol [id=" + id + ", name=" + name + ", detailRegion=" + detailRegion + ", kindOf=" + kindOf
				+ ", content=" + content + ", region=" + region + ", weight=" + weight + ", img=" + img + ", like="
				+ heart + "]";
	}

	public Alcohol(int id, String name, String detailRegion, String kindOf, String content, String region, float weight,
			String img, int heart) {
		super();
		this.id = id;
		this.name = name;
		this.detailRegion = detailRegion;
		this.kindOf = kindOf;
		this.content = content;
		this.region = region;
		this.weight = weight;
		this.img = img;
		this.heart = heart;
	}

	
}
