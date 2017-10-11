package com.neusoft.rule_controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class Rule_modifly
 */
@WebServlet("/Rule_modifly")
public class Rule_modifly extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rule_modifly() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RuleServies cs = new RuleServies();
		int _id = Integer.parseInt(request.getParameter("id"));

		Rule rule = new Rule();
		rule = cs.select(_id);
		
		request.setAttribute("c", rule);
		
        request.getRequestDispatcher("Ruleupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
