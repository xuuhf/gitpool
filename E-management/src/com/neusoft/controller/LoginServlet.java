package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Account;
import com.neusoft.services.LoginServices;
import com.neusoft.util.MD5Utils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/logina")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletRequest session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter pw = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username != null & password != null) {
			LoginServices ls = new LoginServices();
			Account acc = new Account(username,password);
			acc=ls.doLogin(acc);
			if(acc!=null) {
				System.out.println("µÇÂ½³É¹¦");
				//response.sendRedirect("Dianshang.html");
				String isChecked = request.getParameter("check");
				if(isChecked!=null&&isChecked.equals("1")) {
					 Cookie username_cookie = new Cookie("username_cookie",URLEncoder.encode(username,"utf-8"));
				      username_cookie.setMaxAge(7*24*60*60);
				      Cookie psw_cookie = new Cookie("password_cookie",MD5Utils.GetMD5Code(password));
				      psw_cookie.setMaxAge(7*24*60*60);
				      response.addCookie(username_cookie);
				      response.addCookie(psw_cookie);
				}
				HttpSession session = request.getSession();
				session.setAttribute("acc",acc);
				request.getRequestDispatcher("Dianshang.jsp").forward(request, response);
			}else {
				System.out.println("µÇÂ½Ê§°Ü");
			}
		}
		//request.getRequestDispatcher("Dianshang.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
