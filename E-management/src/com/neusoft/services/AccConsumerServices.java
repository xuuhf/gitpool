package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.acc_consumerdao.Acc_consumerDao;
import com.neusoft.dao.Daofactory;
import com.neusoft.entity.Account_consumer;
import com.neusoft.entity.PageModel;
import com.neusoft.util.DaoException;

public class AccConsumerServices {
     Acc_consumerDao ac = Daofactory.getInstance("acc_consmer", Acc_consumerDao.class);
     public boolean add(Account_consumer acc_consumer) {
    	 return ac.insert(acc_consumer);
    	  }
     public boolean remove(int id) {
		return ac.delete(id);
    	 
     }
     public boolean modify(Account_consumer acc_consumer){
		return ac.update(acc_consumer);
    	 
     }
     public Account_consumer show(int id) {
		return ac.select(id);
    	 
     }
     public void getAccount_consumer(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
 		
 		
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
 			
 			
 			PageModel<Account_consumer>  acc=getPageModel(_pageNo,_totalPageNo);
 			if(acc!=null) {
 				int totalPageNo1= (acc. getTotalRecords()%_totalPageNo==0?acc. getTotalRecords()/_totalPageNo:acc.getTotalRecords()/_totalPageNo+1);
 				acc.setTotalPageNo(totalPageNo1);
 				acc.setPageNo(_pageNo);
 			}
 			
 			request.setAttribute("acc", acc);
 			
 			request.getRequestDispatcher("").forward(request, response);
 		}catch(NumberFormatException e) {
 			e.printStackTrace();
 		}

 	}

     public PageModel<Account_consumer> getPageModel(int pageNo, int totalPageNo){
		return ac.getPageModel(pageNo, totalPageNo);
    	 
     }
     public List<Account_consumer> selectList(){
		return ac.selectList();
    	 
     }
     public Account_consumer selectByName(String username, String password) {
		return ac.selectByName(username, password);
    	 
     }
}
