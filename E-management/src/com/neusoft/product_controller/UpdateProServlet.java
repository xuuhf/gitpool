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
 * Servlet implementation class UpdateProServlet
 */
@WebServlet("/UpdateProServlet")
public class UpdateProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Product product = new Product();
		int id = Integer.parseInt(request.getParameter("id"));
		product.setPname(request.getParameter("pname"));
		int cid = Integer.parseInt(request.getParameter("add"));
		product.setPno(request.getParameter("pno"));
		product.setPic(request.getParameter("pic"));
		String price = String.valueOf(request.getParameter("price"));
		int online = Integer.parseInt(request.getParameter("online"));
	   product.setPdetail(request.getParameter("detail"));
	    product.setId(id);
	    product.setCid(cid);
	    product.setOnline(online);
	    
	    ProductServies cs = new ProductServies();
		cs.update(product);
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
