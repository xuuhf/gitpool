package com.neusoft.shoppinginfoController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Shoppinginfo;
import com.neusoft.services.ShoppingInfoServices;

/**
 * Servlet implementation class SifUpdateServlet
 */
@WebServlet("/SifUpdateServlet")
public class SifUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SifUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Shoppinginfo shoppinginfo = new Shoppinginfo();
		int id = Integer.parseInt(request.getParameter("id"));
		int aid = Integer.parseInt(request.getParameter("aid"));
		double money = Double.parseDouble(request.getParameter("money"));
		String nickname = request.getParameter("nickname");
		shoppinginfo.setId(id);
		shoppinginfo.setAid(aid);
		shoppinginfo.setMoney(money);
		shoppinginfo.setLasttime(System.currentTimeMillis());
		shoppinginfo.setNickname(nickname);
		ShoppingInfoServices ss = new ShoppingInfoServices();
		ss.modify(shoppinginfo);
		request.getRequestDispatcher("SifPageModelServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
