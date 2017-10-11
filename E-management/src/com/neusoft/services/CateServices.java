package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.catedao.CateDao;

import com.neusoft.dao.Daofactory;
import com.neusoft.entity.Cate;

import com.neusoft.entity.PageModel;
import com.neusoft.util.DaoException;

public class CateServices {
	CateDao catedao = Daofactory.getInstance("CateDao", CateDao.class);
	
	
	public boolean insert(Cate cate) {
		boolean b = catedao.insert(cate);
	
		return false;
		
	}
	public boolean delete(int cid) {
		boolean b = catedao.delete(cid);
		return false;
		
	}
	public boolean update(Cate cate) {
		boolean b =catedao.update(cate);
		return false;
		
	}
	public Cate select(int cid) {
		Cate cate = catedao.select(cid);
		return cate;
		
	}
	
public void getCate(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		
		
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
			
			
			PageModel<Cate>  cate=getPageModel(_pageNo,_totalPageNo);
			if(cate!=null) {
				int totalPageNo1= (cate. getTotalRecords()%_totalPageNo==0?cate. getTotalRecords()/_totalPageNo:cate.getTotalRecords()/_totalPageNo+1);
				cate.setTotalPageNo(totalPageNo1);
				cate.setPageNo(_pageNo);
			}
			
			request.setAttribute("cate", cate);
			System.out.println("cate==="+cate);
			request.getRequestDispatcher("procate.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}

	}

 public PageModel<Cate> getPageModel(int pageNo,int totalpageSize){
		 PageModel<Cate>  cate= catedao.getPageModel(pageNo, totalpageSize);
		return cate;
	
	 }
 
 
 public List<Cate> selectList() {
	 List<Cate> list = catedao.selectList();
	return list;
	 
 }
 public List<Cate> selectBypid(int pid){
	 List<Cate> list = catedao.selectBypid(pid);
 	return list;
	 
 }
 
}
