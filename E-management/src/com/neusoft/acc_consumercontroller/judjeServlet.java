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
 * Servlet implementation class judjeServlet
 */
@WebServlet("/judjeServlet")
public class judjeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public judjeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Account_consumer acc = null;
		String username = request.getParameter("username");
		String psw = request.getParameter("password");
		AccConsumerServices acs = new AccConsumerServices();
		acc = acs.selectByName(username,psw);
		if(acc!=null) {
			response.sendRedirect("home-page.jsp");
		}else {
			String err = "用户名或密码错误";
			request.setAttribute("err", err);
			request.getRequestDispatcher("conslongin.jsp").forward(request, response);
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
