package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.Daofactory;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Shoppinginfo;
import com.neusoft.shoppinginfoDao.ShoppinginfoDao;
import com.neusoft.util.DaoException;

public class ShoppingInfoServices {
	ShoppinginfoDao sif = Daofactory.getInstance("shoppinginfoDao",ShoppinginfoDao.class);
	public boolean add(Shoppinginfo shoppinginfo) {
		return sif.insert(shoppinginfo);
		
	}
	public boolean remove(int id) {
		return sif.delete(id);
		
	}
	public boolean modify(Shoppinginfo shoppinginfo) {
		return sif.update(shoppinginfo);
		
	}
	public Shoppinginfo show(int id) {
		return sif.select(id);
		
	}
public void getShoppinginfo(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		
		
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
			
			
			PageModel<Shoppinginfo>  shoppinginfo=getPageModel(_pageNo,_totalPageNo);
			if(shoppinginfo!=null) {
				int totalPageNo1= (shoppinginfo. getTotalRecords()%_totalPageNo==0?shoppinginfo. getTotalRecords()/_totalPageNo:shoppinginfo.getTotalRecords()/_totalPageNo+1);
				shoppinginfo.setTotalPageNo(totalPageNo1);
				shoppinginfo.setPageNo(_pageNo);
			}
			
			request.setAttribute("shoppinginfo", shoppinginfo);
			request.getRequestDispatcher("member.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}

	}
	public PageModel<Shoppinginfo> getPageModel(int pageNo, int totalPageNo){
		return sif.getPageModel(pageNo, totalPageNo);
		
	}
	public List<Shoppinginfo> selectList(){
		return sif.selectList();
		
	}
}
