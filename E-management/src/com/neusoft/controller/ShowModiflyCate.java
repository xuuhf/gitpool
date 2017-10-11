package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Cate;
import com.neusoft.services.CateServices;

/**
 * Servlet implementation class ShowModiflyCate
 */
@WebServlet("/ShowModiflyCate")
public class ShowModiflyCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowModiflyCate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CateServices cs = new CateServices();
		int _cid = Integer.parseInt(request.getParameter("cid"));
	//	System.out.println(cid);
		Cate cate = new Cate();
		cate = cs.select(_cid);
		List<Cate> list = cs.selectBypid(0);
		request.setAttribute("c", cate);
		request.setAttribute("cate", list);
        request.getRequestDispatcher("update.jsp").forward(request, response);
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
