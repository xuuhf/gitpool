package com.neusoft.acc_consumercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Account_consumer;
import com.neusoft.services.AccConsumerServices;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String usename = request.getParameter("username");
		String psw =request.getParameter("password");
		AccConsumerServices acs = new AccConsumerServices();
	    Account_consumer acc = new Account_consumer();
	    acc.setPassword(psw);
	    acc.setLoginname(usename);
	    acc.setIP(request.getRemoteAddr());
	    acc.setRegistertime(System.currentTimeMillis());
	    acc.setLastlogintime(System.currentTimeMillis());
	    
	   if(acs.add(acc)){
		   System.out.println("×¢²á³É¹¦");
	   }else {
		   System.out.println("×¢²áÊ§°Ü");
	   }
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
