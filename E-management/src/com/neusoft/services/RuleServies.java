package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.Daofactory;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;
import com.neusoft.ruledao.RuleDao;
import com.neusoft.util.DaoException;

public class RuleServies {
	RuleDao ruledao = Daofactory.getInstance("ruledao", RuleDao.class);
	public boolean insert(Rule rule) {
		boolean b = ruledao.insert(rule);
	
		return false;
		
	}
	public boolean delete(int cid) {
		boolean b = ruledao.delete(cid);
		return false;
		
	}
	public boolean update(Rule rule) {
		boolean b =ruledao.update(rule);
		return false;
		
	}
	public Rule select(int id) {
		Rule rule = ruledao.select(id);
		return rule;
		
	}
	
public void getRule(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		
		
		String pageNo=request.getParameter("pageNo");
		String totalPageNo=request.getParameter("totalPageNo");
		
		if(pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		if(totalPageNo == null || totalPageNo.equals("")) {
			totalPageNo = "2";
		}
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _totalPageNo=Integer.parseInt(totalPageNo);
			
			
			PageModel<Rule> rule=getPageModel(_pageNo,_totalPageNo);
			if(rule!=null) {
				int totalPageNo1= (rule. getTotalRecords()%_totalPageNo==0?rule. getTotalRecords()/_totalPageNo:rule.getTotalRecords()/_totalPageNo+1);
				rule.setTotalPageNo(totalPageNo1);
				rule.setPageNo(_pageNo);
			}
			
			request.setAttribute("rule", rule);
			
			request.getRequestDispatcher("Rule.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}

	}

 public PageModel<Rule> getPageModel(int pageNo,int totalpageSize){
		 PageModel<Rule> rule= ruledao.getPageModel(pageNo, totalpageSize);
		return rule;
	
	 }
 
 
 public List<Rule> selectList() {
	 List<Rule> list = ruledao.selectList();
	return list;
	 
 }
}
