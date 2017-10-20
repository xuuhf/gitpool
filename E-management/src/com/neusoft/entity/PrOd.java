package com.neusoft.entity;

public class PrOd {
	
	private int id;
	private String pname;
	private int count;
	private double totalprice;
	@Override
	public String toString() {
		return "PrOd [id=" + id + ", pname=" + pname + ", count=" + count + ", totalprice=" + totalprice + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

}
