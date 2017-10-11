package com.neusoft.entity;

import java.io.Serializable;

public class Rule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3632051636385719499L;
                  private  int id  ;      
                  private int pid ;       
                  private String size;
				public Rule() {
					super();
				}
				public Rule(int pid, String size) {
					super();
					this.pid = pid;
					this.size = size;
				}
				public Rule(int id, int pid, String size) {
					super();
					this.id = id;
					this.pid = pid;
					this.size = size;
				}
				public int getId() {
					return id;
				}
				public void setId(int id) {
					this.id = id;
				}
				public int getPid() {
					return pid;
				}
				public void setPid(int pid) {
					this.pid = pid;
				}
				public String getSize() {
					return size;
				}
				public void setSize(String size) {
					this.size = size;
				}
				public static long getSerialversionuid() {
					return serialVersionUID;
				}
				@Override
				public String toString() {
					return "Rule [id=" + id + ", pid=" + pid + ", size=" + size + "]";
				}  
                  
}
