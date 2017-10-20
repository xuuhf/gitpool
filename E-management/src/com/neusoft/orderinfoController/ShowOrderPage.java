package com.neusoft.orderinfoController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.OrderInfo;
import com.neusoft.entity.PageModel;
import com.neusoft.services.OrderInfoServices;

/**
 * Servlet implementation class ShowOrderPage
 */
@WebServlet("/showorderpage")
public class ShowOrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrderPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNo = "1";
		String pageSize = "2";
		
		String _pageNo = request.getParameter("pageNo");
		String _pageSize = request.getParameter("pageSize");
		if(_pageNo == null || "".equals(_pageNo)) 	_pageNo = pageNo;
		if(_pageSize == null || "".equals(_pageSize)) 	_pageSize = pageSize;
		
		OrderInfoServices ois = new OrderInfoServices();
		int pn = Integer.parseInt(_pageNo);
		int ps = Integer.parseInt(_pageSize);
		PageModel<OrderInfo> pm = ois.getPageModel(pn, ps);
		pm.setPageNo(pn);
		pm.setTotalPageNo(pm.getTotalRecords()%2==0?pm.getTotalRecords()/ps:pm.getTotalRecords()/ps+1);
		request.setAttribute("pm", pm);
		request.getRequestDispatcher("finishtest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
