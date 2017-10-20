package com.neusoft.orderinfoController;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Consumer_addr;
import com.neusoft.entity.OrderInfo;
import com.neusoft.entity.Product_orderinfor;
import com.neusoft.services.ConAddrServices;
import com.neusoft.services.OrderInfoServices;
import com.neusoft.services.Pro_OrderServices;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	ConAddrServices cs = new ConAddrServices();
	Consumer_addr ca = new Consumer_addr();
	System.currentTimeMillis();
	//保存买家地址信息
	ca.setName(request.getParameter("name"));
	ca.setAddr(request.getParameter("addr"));
	ca.setPhone(request.getParameter("phone"));
	ca.setProvice(request.getParameter("sel1"));
	ca.setCity(request.getParameter("sel2"));
	ca.setArea(request.getParameter("sel3"));
	cs.insert(ca);

	
	OrderInfoServices ofs = new OrderInfoServices();
	OrderInfo oi = new OrderInfo();
	String orderno = UUID.randomUUID().toString();
	oi.setOrderno(orderno);
	int paystatus = Integer.parseInt(request.getParameter("yes"));
	oi.setPaystatus(paystatus);
	oi.setAddrinto(cs.selectList().get(0).getId());
	oi.setOrdertime(System.currentTimeMillis());
	oi.setPaytime(System.currentTimeMillis());
	oi.setMask(request.getParameter("mask"));
	ofs.insert(oi);
	
	
	
	Pro_OrderServices pos = new Pro_OrderServices();
	Product_orderinfor po = new Product_orderinfor();
	
	String[] pid = request.getParameterValues("pid");
	String[] productid = request.getParameterValues("productid");
	String[] count = request.getParameterValues("count");
	String[] price = request.getParameterValues("price");
	for(int i=0; i<pid.length; i++) {
		po.setProductid(Integer.parseInt(productid[i]));
		
		po.setCount(Integer.parseInt(count[i]));
		po.setOrderid(ofs.selectList().get(0).getId());
		po.setProductid(Integer.parseInt(pid[i]));
		po.setPrice(Double.parseDouble(price[i]));
		pos.insert(po);
	}
	
	request.getRequestDispatcher("ShowCateServlet?cid=2").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
