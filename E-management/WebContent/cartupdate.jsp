<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.neusoft.entity.Cart" %>
     <%@ page import="com.neusoft.entity.Cart" %>
      <%@ page import="java.util.List"%>
      <%@page import="com.neusoft.entity.CartItem"%>
    <%//通过session查看是否有购物车
    Cart cart = (Cart)session.getAttribute("cart");
    if(cart == null){
    	cart = new Cart();
    	session.setAttribute("cart", cart);
    }
    %>
    <%
    if(cart == null){
    	System.out.print("没有购物车");
    	return;
    }
    List<CartItem> items = cart.getItems();
    for(int i=0;i<items.size();i++){
    	CartItem ci = items.get(i);
    	String strCount = request.getParameter("p"+ci.getProductId());
    	if(strCount !=null&!strCount.trim().equals(""));
    	ci.setCount(Integer.parseInt(strCount));
    }
    response.sendRedirect("cart.jsp");
    
    
    %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 
<body>

</body>
</html>