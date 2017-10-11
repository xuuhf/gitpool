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
 * Servlet implementation class Rule_updateServlet
 */
@WebServlet("/Rule_updateServlet")
public class Rule_updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rule_updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Rule rule = new Rule();
	
		int id = Integer.parseInt(request.getParameter("id"));
	    int pid = Integer.parseInt(request.getParameter("pno"));
	    rule.setSize(request.getParameter("size"));
	    rule.setId(id);
	    rule.setPid(pid);
	    RuleServies cs = new RuleServies();
		cs.update(rule);
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
