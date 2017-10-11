package com.neusoft.entity;

public class Consumer_addr {
private int	 id;          
private String name ;         
private String addr ;        
private String phone;        
 private String provice;      
private String city ;       
private String  area;
public Consumer_addr() {
	super();
}
public Consumer_addr(String name, String addr, String phone, String provice, String city, String area) {
	super();
	this.name = name;
	this.addr = addr;
	this.phone = phone;
	this.provice = provice;
	this.city = city;
	this.area = area;
}
public Consumer_addr(int id, String name, String addr, String phone, String provice, String city, String area) {
	super();
	this.id = id;
	this.name = name;
	this.addr = addr;
	this.phone = phone;
	this.provice = provice;
	this.city = city;
	this.area = area;
}
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
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getProvice() {
	return provice;
}
public void setProvice(String provice) {
	this.provice = provice;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
@Override
public String toString() {
	return "Consumer_addr [id=" + id + ", name=" + name + ", addr=" + addr + ", phone=" + phone + ", provice=" + provice
			+ ", city=" + city + ", area=" + area + "]";
}         

}
