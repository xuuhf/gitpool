package com.neusoft.entity;

public class Product_orderinfor {
private int	 orderid ;       //����id ֵ ������orderinfo���е�id
private int	 productid ;    //��Ʒid, ������  product���е�id
public Product_orderinfor() {
	super();
}
public Product_orderinfor(int orderid, int productid) {
	super();
	this.orderid = orderid;
	this.productid = productid;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
@Override
public String toString() {
	return "Product_orderinfor [orderid=" + orderid + ", productid=" + productid + "]";
}

}
