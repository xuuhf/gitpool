package com.neusoft.shoppinginfoController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Product;
import com.neusoft.entity.Shoppinginfo;
import com.neusoft.services.ShoppingInfoServices;

/**
 * Servlet implementation class SifShowServlet
 */
@WebServlet("/SifShowServlet")
public class SifShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SifShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Shoppinginfo shoppingInfo = new Shoppinginfo();
		int id = Integer.parseInt(request.getParameter("id"));
		ShoppingInfoServices ss = new ShoppingInfoServices();
		shoppingInfo=ss.show(id);
		request.setAttribute("cc", shoppingInfo);
		request.getRequestDispatcher("memberUpdate.jsp").forward(request, response);
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
