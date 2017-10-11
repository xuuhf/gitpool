package com.neusoft.product_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.services.ProductServies;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowCateServlet")
public class ShowCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProductServies cs = new ProductServies ();
		int cid = Integer.parseInt(request.getParameter("cid"));
		String pageNo=request.getParameter("pageNo");
		String totalPageNo=request.getParameter("totalPageNo");
		if(pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		if(totalPageNo == null || totalPageNo.equals("")) {
			totalPageNo = "5";
		}
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _totalPageNo=Integer.parseInt(totalPageNo);
			
			PageModel<Product>  product = cs.getPageModelByCid(cid, _pageNo, _totalPageNo);
			if(product!=null) {
				int totalPageNo1= (product. getTotalRecords()%_totalPageNo==0?product. getTotalRecords()/_totalPageNo:product.getTotalRecords()/_totalPageNo+1);
				product.setTotalPageNo(totalPageNo1);
				product.setPageNo(_pageNo);
			}
			
			request.setAttribute("product", product);
			request.getRequestDispatcher("clothes.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
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
