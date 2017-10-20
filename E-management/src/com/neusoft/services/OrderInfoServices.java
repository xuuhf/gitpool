package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.Daofactory;
import com.neusoft.entity.OrderInfo;
import com.neusoft.entity.PageModel;
import com.neusoft.orderinfodao.OrderInfoDao;
import com.neusoft.util.DaoException;

public class OrderInfoServices {
	
	OrderInfoDao oif = Daofactory.getInstance("OrderInfoDao", OrderInfoDao.class);
	public boolean insert(OrderInfo orderinfo) {
		return oif.insert(orderinfo);
		
	}
	public boolean remove(int id) {
		return oif.delete(id);
		
	}
	public boolean modify(OrderInfo orderinfo) {
		return oif.update(orderinfo);
		
	}
	public OrderInfo show(int id) {
		return oif.select(id);
		
	}
public void getOrderInfo(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		
		
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
			
			
			PageModel<OrderInfo>  oInif=getPageModel(_pageNo,_totalPageNo);
			if(oInif!=null) {
				int totalPageNo1= (oInif. getTotalRecords()%_totalPageNo==0?oInif. getTotalRecords()/_totalPageNo:oInif.getTotalRecords()/_totalPageNo+1);
				oInif.setTotalPageNo(totalPageNo1);
				oInif.setPageNo(_pageNo);
			}
			
			request.setAttribute("oInif", oInif);
			
			request.getRequestDispatcher("order.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}

	}

	public PageModel<OrderInfo> getPageModel(int pageNo, int totalPageNo){
		return oif.getPageModel(pageNo, totalPageNo);
		
	}
	public List<OrderInfo> selectList(){
		return oif.selectList();
	}
	
}
