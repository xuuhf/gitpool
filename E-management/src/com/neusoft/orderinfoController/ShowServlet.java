package com.neusoft.orderinfoController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Consumer_addr;
import com.neusoft.entity.OrderInfo;
import com.neusoft.entity.PrOd;
import com.neusoft.entity.ProOrder;
import com.neusoft.entity.Product;
import com.neusoft.entity.Product_orderinfor;
import com.neusoft.services.ConAddrServices;
import com.neusoft.services.OrderInfoServices;
import com.neusoft.services.Pro_OrderServices;
import com.neusoft.services.ProductServies;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		OrderInfo oi = new OrderInfo();
		int id = Integer.parseInt(request.getParameter("id"));
		OrderInfoServices ofs = new OrderInfoServices();
		oi = ofs.show(id);
		
		
		ConAddrServices cs = new ConAddrServices();
		Consumer_addr ca = new Consumer_addr();
		ca = cs.show(oi.getAddrinto());
		
		Pro_OrderServices pos = new Pro_OrderServices();
		ProductServies ps = new ProductServies();
		List<Product_orderinfor> pro_od = pos.selectList(id);
		List<PrOd> pdlist = new ArrayList<>();
		
		for(int i=0;i<pro_od.size();i++) {
			PrOd pd = new PrOd();
			Product prod = ps.select(pro_od.get(i).getProductid());
			pd.setId(prod.getId());
			pd.setCount(pro_od.get(i).getCount());
			pd.setPname(prod.getPname());
			pd.setTotalprice(pro_od.get(i).getPrice());
			pdlist.add(pd);
		}
		
		//三表信息暂存类
		ProOrder po = new ProOrder();
	    po.setCad(ca);
	    po.setOi(oi);
	    po.setPd(pdlist);
	    
		request.setAttribute("po",po);
		request.getRequestDispatcher("waitting.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
