package com.neusoft.services;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.consumer_addDao.Consumer_addrDao;
import com.neusoft.dao.Daofactory;
import com.neusoft.entity.Consumer_addr;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Shoppinginfo;
import com.neusoft.util.DaoException;

public class ConAddrServices {
	Consumer_addrDao cd=Daofactory.getInstance("consumer_addrDao",Consumer_addrDao.class);
	
	public boolean insert(Consumer_addr consumer_addr) {
		return cd.insert(consumer_addr) ;
		
	}
	public boolean remove(int id) {
		return cd.delete(id);
		
	}
	public boolean modify(Consumer_addr consumer_addr) {
		return cd.update(consumer_addr);
		
	}
	public Consumer_addr show(int id) {
		return cd.select(id);
		
	}
public void getConsumer_addr(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		
		
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
			
			
			PageModel<Consumer_addr>  consumer_addr=getPageModel(_pageNo,_totalPageNo);
			if(consumer_addr!=null) {
				int totalPageNo1= (consumer_addr. getTotalRecords()%_totalPageNo==0?consumer_addr. getTotalRecords()/_totalPageNo:consumer_addr.getTotalRecords()/_totalPageNo+1);
				consumer_addr.setTotalPageNo(totalPageNo1);
				consumer_addr.setPageNo(_pageNo);
			}
			
			request.setAttribute("consumer_addr", consumer_addr);
			request.getRequestDispatcher("address.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}

	}
	public PageModel<Consumer_addr> getPageModel(int pageNo, int totalPageNo){
		return cd.getPageModel(pageNo, totalPageNo);
		
	}
	public List<Consumer_addr> selectList(){
		return cd.selectList();
		
	}
}
