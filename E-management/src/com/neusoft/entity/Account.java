package com.neusoft.entity;

import java.io.Serializable;

public class Account implements Serializable{

	
	private static final long serialVersionUID = 6301075639694428811L;
	
	private String username;
	private String password;
	private long loginDate;
	private int id;
	public Account() {
		super();
	}

	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Account(int id, String username, String password, long loginDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.loginDate = loginDate;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(long loginDate) {
		this.loginDate = loginDate;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", loginDate=" + loginDate
				+ "]";
	}
	
	

}
