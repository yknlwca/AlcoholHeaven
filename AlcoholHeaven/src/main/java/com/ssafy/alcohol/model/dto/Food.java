package com.ssafy.alcohol.model.dto;

public class Food {
//	menu text NOT NULL,
//	kindOf VARCHAR(20) ,
//	content TEXT,
//	region VARCHAR(20) NOT NULL,
//	file TEXT
	private int id;

	private String menu;
	private String kindOf;
	private String content;
	private String region;
	private String file;
	private String writer;
	public Food(int id, String menu, String kindOf, String content, String region, String file, String writer) {
		super();
		this.id = id;
		this.menu = menu;
		this.kindOf = kindOf;
		this.content = content;
		this.region = region;
		this.file = file;
		this.writer = writer;
	}
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
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", menu=" + menu + ", kindOf=" + kindOf + ", content=" + content + ", region="
				+ region + ", file=" + file + ", writer=" + writer + "]";
	}
	
	
	
	
}
