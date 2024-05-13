package com.ssafy.alcohol.model.dto;

public class Friend {
//	name VARCHAR(20) NOT NULL,
//	sex BOOLEAN NOT NULL,
//	age INT NOT NULL,
//	kindOf VARCHAR(20),
//	region VARCHAR(20) NOT NULL,
//	intro TEXT NOT NULL
	private int id;
	private String name;
	private Boolean sex;
	private int age;
	private String kindOf;
	private String region;
	private String intro;
	
	
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
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	
	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", kindOf=" + kindOf
				+ ", region=" + region + ", intro=" + intro + "]";
	}
	
	
}
