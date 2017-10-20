package com.neusoft.entity;

public class CartItem {
     private int productId;
     private int count;//¹ºÂòÊýÁ¿
     private double price;
     private String pname;
    public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public CartItem() {
    	
    }
     
	public CartItem(int productId, int count, double price) {
		super();
		this.productId = productId;
		this.count = count;
		this.price = price;
	}
	
	public CartItem(int productId, int count, double price, String pname) {
		super();
		this.productId = productId;
		this.count = count;
		this.price = price;
		this.pname = pname;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
     public double getTotalPrice() {
    	 return price*count;
     }
}
