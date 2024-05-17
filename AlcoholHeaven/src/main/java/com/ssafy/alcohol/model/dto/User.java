package com.ssafy.alcohol.model.dto;

public class User {
	private int userKey;
	private String id;
	private String password;
	private String name;
	private String idNumber;
	private String email;
	private String phoneNumber;
	public int getUserKey() {
		return userKey;
	}
	public void setUserKey(int userKey) {
		this.userKey = userKey;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public User(int userKey, String id, String password, String name, String idNumber, String email,
			String phoneNumber) {
		super();
		this.userKey = userKey;
		this.id = id;
		this.password = password;
		this.name = name;
		this.idNumber = idNumber;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userKey=" + userKey + ", id=" + id + ", password=" + password + ", name=" + name + ", idNumber="
				+ idNumber + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
