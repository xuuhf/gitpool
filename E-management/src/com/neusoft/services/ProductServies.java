package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.Daofactory;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.productdao.ProductDao;
import com.neusoft.util.DaoException;

public class ProductServies {
	 ProductDao productdao = Daofactory.getInstance("ProductDao", ProductDao.class);
	 
	 public boolean insert(Product product) {
			boolean b = productdao.insert(product);
		
			return false;
			
		}
	 public List<Product> selectList() {
		 
		 List<Product> list = productdao.selectList();
		return list;
		 
	 }
	 public boolean delete(int cid) {
		 boolean b = productdao.delete(cid);
		return false;
		 
	 }
	 public boolean update(Product product) {
		 boolean b = productdao.update(product);
		 
		return false;
		 
	 }
	 public void getProduct(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
			
			
			String pageNo=request.getParameter("pageNo");
			String totalPageNo=request.getParameter("totalPageNo");
			if(pageNo == null || pageNo.equals("")) {
				pageNo = "1";
			}
			if(totalPageNo == null || totalPageNo.equals("")) {
				totalPageNo = "5";
			}
			try {
				int _pageNo=Integer.parseInt(pageNo);
				int _totalPageNo=Integer.parseInt(totalPageNo);
				
				
				PageModel<Product>  product=getPageModel(_pageNo,_totalPageNo);
				if(product!=null) {
					int totalPageNo1= (product. getTotalRecords()%_totalPageNo==0?product. getTotalRecords()/_totalPageNo:product.getTotalRecords()/_totalPageNo+1);
					product.setTotalPageNo(totalPageNo1);
					product.setPageNo(_pageNo);
				}
				
				request.setAttribute("product", product);
				request.getRequestDispatcher("product.jsp").forward(request, response);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}

		}

	 public PageModel<Product> getPageModel(int pageNo,int totalpageSize){
			 PageModel<Product>  product= productdao.getPageModel(pageNo, totalpageSize);
			return product;
		
		 }
	 public PageModel<Product> getPageModelByCid(int cid, int pageNo,int totalpageSize){
		 PageModel<Product>  product= productdao.getPageModelByCid(cid,pageNo, totalpageSize);
		return product;
	
	 }
	 
	 public Product select(int id) {
		 Product product = productdao.select(id);
			return product;
			
		}
}
