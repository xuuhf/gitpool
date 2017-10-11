package com.neusoft.entity;

import java.io.Serializable;

public class Cate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5245375642801391271L;
	
	private int cid;
	private String cname;
	private int pid;
	public Cate() {
		super();
	}
	public Cate(int cid, String cname, int pid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.pid = pid;
	}
	
	public Cate(String cname, int pid) {
		super();
		this.cname = cname;
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Cate [cid=" + cid + ", cname=" + cname + ", pid=" + pid + "]";
	}
	
	
      
}
