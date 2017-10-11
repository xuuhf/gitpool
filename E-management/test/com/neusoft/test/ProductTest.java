package com.neusoft.test;


import java.util.List;


import com.neusoft.dao.Daofactory;

import com.neusoft.entity.Product;
import com.neusoft.productdao.ProductDao;

public class ProductTest {
  public static void main(String[] args) {
	//  testSelectList() ;
	  testInsert();
}
 
  public static void testInsert() {
	  ProductDao productdao = Daofactory.getInstance("ProductDao", ProductDao.class);
	//Product product = new Product("ÍâÌ×",3,"1112","a.jpg",0.0,1);
	 //System.out.println(productdao.insert(product));
  }
  public static void testSelectList() {
	  ProductDao productdao = Daofactory.getInstance("ProductDao", ProductDao.class);
		 List<Product> list = productdao.selectList();
		 System.out.println(list);
  }
}
