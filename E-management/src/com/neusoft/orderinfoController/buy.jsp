<%@page import="com.neusoft.services.ProductServies"%>
<%@page import="com.neusoft.entity.CartItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.neusoft.entity.Cart" %>
     <%@ page import="com.neusoft.entity.Product" %>
     <%@ page import="java.util.List"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%//通过session查看是否有购物车
    Cart cart = (Cart)session.getAttribute("cart");
    if(cart == null){
    	cart = new Cart();
    	session.setAttribute("cart", cart);
    }
 %>
  
<%
  request.setCharacterEncoding("UTF-8");
  int id = Integer.parseInt(request.getParameter("id"));
  CartItem ci = new CartItem();
  Product p = new ProductServies().select(id);
  ci.setPname(p.getPname());
  ci.setProductId(id);
  ci.setPrice(p.getPrice());
  ci.setCount(1);
  cart.add(ci);
  
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