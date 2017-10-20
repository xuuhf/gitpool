package com.neusoft.services;

import java.util.List;

import com.neusoft.dao.Daofactory;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product_orderinfor;
import com.neusoft.product_orderDao.Product_orderinforDao;

public class Pro_OrderServices {
	Product_orderinforDao  po =  Daofactory.getInstance("Product_orderinforDao",Product_orderinforDao.class);
	public boolean insert(Product_orderinfor product_orderfor) {
		return po.insert(product_orderfor);
		
	}
	public boolean delete(int orderid,int  productid) {
		return po.delete(orderid, productid);
		
	}
	public boolean update(Product_orderinfor product_orderfor) {
		return po.update(product_orderfor);
		
	}
	public Product_orderinfor select(int orderid) {
		return po.select(orderid);
		
	}
	public PageModel<Product_orderinfor> getPageModel(int pageNo, int totalPageNo){
		return po.getPageModel(pageNo, totalPageNo);
		
	}
	public List<Product_orderinfor> selectList(){
		return po.selectList();
		
	}
	
	public List<Product_orderinfor> selectList(int id){
		return po.selectList(id);
		
	}
}
