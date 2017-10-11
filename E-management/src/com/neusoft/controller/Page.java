package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neusoft.entity.Account;
import com.neusoft.services.LoginServices;
import com.neusoft.util.MD5Utils;

/**
 * 
 */
@WebServlet("/helloservlet")
public class Page extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page() {
        super();
        // TODO Auto-generated constructor stub
        
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    }
    
	/**
	 * @param session 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, ServletRequest session) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(1);
		System.out.println(1233);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("psw");
		
		if(username != null & password != null) {
			LoginServices ls = new LoginServices();
			Account acc = new Account(username,password);
			acc=ls.doLogin(acc);
			if(acc!=null) {
				//System.out.println("µÇÂ½³É¹¦");
				//response.sendRedirect("Dianshang.html");
				/*String isChecked = request.getParameter("check");
				if(isChecked!=null&&isChecked.equals("1")) {
					 Cookie username_cookie = new Cookie("username_cookie",URLEncoder.encode(username,"utf-8"));
				      username_cookie.setMaxAge(7*24*60*60);
				      Cookie psw_cookie = new Cookie("password_cookie",MD5Utils.GetMD5Code(password));
				      psw_cookie.setMaxAge(7*24*60*60);
				      response.addCookie(username_cookie);
				      response.addCookie(psw_cookie);
				}*/
				
				
				session.setAttribute("acc",acc);
				request.getRequestDispatcher("Dianshang.html").forward(request,response);
			}else {
				System.out.println("µÇÂ½Ê§°Ü");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		
	}

}
