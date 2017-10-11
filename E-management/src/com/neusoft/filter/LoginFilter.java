package com.neusoft.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.neusoft.entity.Account;
import com.neusoft.services.LoginServices;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("unused")
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
          HttpServletRequest request = ( HttpServletRequest)req;
          HttpServletResponse response = ( HttpServletResponse)resp;
          
          Cookie [] cookies = request.getCookies();
          Cookie username_cookie = null;
          Cookie psw_cookie = null;
          String username = null;
          String password = null;
          if(cookies!=null&&cookies.length>1) {
  			for(Cookie c:cookies) { 
  				String name = c.getName();
  				String value = c.getValue();
  				
  				if(name!=null&&name.equals("username_cookie")) {
  					username = URLDecoder.decode(value,"utf-8");
  					System.out.println("½âÂëºóusername"+username);
  					username_cookie = c;
  				}if(name!=null&&name.equals("psw_cookie")) {
  					password = value;
  					psw_cookie = c;
  				}
  				
  			}
		
          }
		if(username!=null&&password!=null) {
			LoginServices ls = new LoginServices(); 
			Account acc = new Account(username,password);
			acc=ls.doLogin(acc);
			if(acc!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("acc", acc);
				request.getRequestDispatcher("Dianshang.html").forward(request,response);
				
			}else {
				username_cookie.setMaxAge(0);
				psw_cookie.setMaxAge(0);
				response.addCookie(username_cookie);
				response.addCookie(psw_cookie);
				response.sendRedirect("login.jsp");
			}
		}
		
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
