package com.neusoft.entity;

public class Shoppinginfo {
private int	id;			 
private int aid;  	
private String 	nickname ;	 
private double	money;  	  	  
private long   	lasttime;
public Shoppinginfo() {
	super();
}
public Shoppinginfo(int id, int aid, String nickname, double money, long lasttime) {
	super();
	this.id = id;
	this.aid = aid;
	this.nickname = nickname;
	this.money = money;
	this.lasttime = lasttime;
}
public Shoppinginfo(int aid, String nickname, double money, long lasttime) {
	super();
	this.aid = aid;
	this.nickname = nickname;
	this.money = money;
	this.lasttime = lasttime;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public double getMoney() {
	return money;
}
public void setMoney(double money) {
	this.money = money;
}
public long getLasttime() {
	return lasttime;
}
public void setLasttime(long lasttime) {
	this.lasttime = lasttime;
}
@Override
public String toString() {
	return "Shoppinginfo [id=" + id + ", aid=" + aid + ", nickname=" + nickname + ", money=" + money + ", lasttime="
			+ lasttime + "]";
} 

}
