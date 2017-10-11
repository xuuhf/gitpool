package com.neusoft.entity;

public class Account_consumer {
  private int id ;           
  private String loginname ;   
  private String password;       
  private long registertime;	    
  private long lastlogintime ;   
  private String IP ;
public Account_consumer() {
	super();
}
public Account_consumer(int id, String loginname, String password, long registertime, long lastlogintime, String iP) {
	super();
	this.id = id;
	this.loginname = loginname;
	this.password = password;
	this.registertime = registertime;
	this.lastlogintime = lastlogintime;
	IP = iP;
}
public Account_consumer(String loginname, String password, long registertime, long lastlogintime, String iP) {
	super();
	this.loginname = loginname;
	this.password = password;
	this.registertime = registertime;
	this.lastlogintime = lastlogintime;
	IP = iP;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLoginname() {
	return loginname;
}
public void setLoginname(String loginname) {
	this.loginname = loginname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getRegistertime() {
	return registertime;
}
public void setRegistertime(long registertime) {
	this.registertime = registertime;
}
public long getLastlogintime() {
	return lastlogintime;
}
public void setLastlogintime(long lastlogintime) {
	this.lastlogintime = lastlogintime;
}
public String getIP() {
	return IP;
}
public void setIP(String iP) {
	IP = iP;
}
@Override
public String toString() {
	return "Account_consumer [id=" + id + ", loginname=" + loginname + ", password=" + password + ", registertime="
			+ registertime + ", lastlogintime=" + lastlogintime + ", IP=" + IP + "]";
} 
  
}
