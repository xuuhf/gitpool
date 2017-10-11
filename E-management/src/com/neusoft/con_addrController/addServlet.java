package com.neusoft.con_addrController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Consumer_addr;
import com.neusoft.services.ConAddrServices;

/**
 * Servlet implementation class addServlet
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ConAddrServices css = new ConAddrServices();
		Consumer_addr ca = new Consumer_addr();
		//int id = Integer.parseInt(request.getParameter("id"));
		//ca.setId(id);
		ca.setName(request.getParameter("name"));
		ca.setAddr(request.getParameter("addr"));
		ca.setPhone(request.getParameter("phone"));
		ca.setProvice(request.getParameter("sel1"));
		ca.setCity(request.getParameter("sel2"));
		ca.setArea(request.getParameter("sel3"));
		css.insert(ca);
		request.getRequestDispatcher("PageModelServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
