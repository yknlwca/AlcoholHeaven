package com.ssafy.alcohol.model.dto;

public class Alcohol {
//	name VARCHAR(20) NOT NULL,
//	detailRegion VARCHAR(20) ,
//	kindOf VARCHAR(20),
//	content TEXT,
//	region VARCHAR(20) NOT NULL
	
	private String name;
	private String detailRegion;
	private String kindOf;
	private String content;
	private String region;
	
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
		return "Alcohol [name=" + name + ", detailRegion=" + detailRegion + ", kindOf=" + kindOf + ", content="
				+ content + ", region=" + region + "]";
	}
	
	
}
