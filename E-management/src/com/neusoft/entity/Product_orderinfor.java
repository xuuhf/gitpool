package com.neusoft.entity;

public class Product_orderinfor {
private int	 orderid ;       //订单id 值 引用自orderinfo表中的id
private int	 productid ;    //商品id, 引用自  product表中的id
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
