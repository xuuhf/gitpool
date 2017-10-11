package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessioServlet
 */
@WebServlet("/SessioServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(10);
		if(session.isNew()) {
			pw.println("<p>新建一个会话，会话id:"+session.getId()+"</p>");
		}else{
			pw.println("<p>已存在一个会话，会话id:"+session.getId()+"</p>");
		}
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		String _date = date.format(session.getCreationTime());
		pw.println("<p>session的创建时间:"+_date+"</p>");
		String last_date = date.format(session.getLastAccessedTime());
		pw.println("<p>最后会话结束时间"+last_date+"</p>");
		pw.println("<p>会话超时间"+session.getMaxInactiveInterval()+"</p>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
