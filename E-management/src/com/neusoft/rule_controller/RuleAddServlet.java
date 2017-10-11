package com.neusoft.rule_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Cate;
import com.neusoft.entity.Rule;
import com.neusoft.services.CateServices;
import com.neusoft.services.RuleServies;

/**
 * Servlet implementation class RuleAddServlet
 */
@WebServlet("/RuleAddServlet")
public class RuleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RuleAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Rule rule = new Rule();
		rule.setSize(request.getParameter("size"));
		int pid = Integer.parseInt(request.getParameter("pno")); //"1"  "a"
		rule.setPid(pid);
		RuleServies cs = new RuleServies();
		cs.insert(rule);
	    request.getRequestDispatcher("Rule_PagemodelServlet").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
