package com.neusoft.product_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Cate;
import com.neusoft.entity.Product;
import com.neusoft.services.CateServices;
import com.neusoft.services.ProductServies;

/**
 * Servlet implementation class Pro_addServlet
 */
@WebServlet("/Pro_addServlet")
public class Pro_addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pro_addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Product product = new Product();
		product.setPname(request.getParameter("pname"));
		int cid = Integer.parseInt(request.getParameter("add"));
		product.setPno(request.getParameter("pno"));
		product.setPic(request.getParameter("pic"));
		double price = Double.parseDouble(request.getParameter("price"));
		int online = Integer.parseInt(request.getParameter("online"));
	     String edit = request.getParameter("edit");
		product.setPdetail(edit);
		product.setCid(cid);
	    product.setOnline(online);
	    System.out.println(product);
		ProductServies  cs = new ProductServies ();
		cs.insert(product);
	    request.getRequestDispatcher("Pro_PagemodelServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
