<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.neusoft.entity.Cart" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    %>
    <form action="order.jsp" method="post">
    <table >
  <tr>
    <td>商品id</td>
    <td>商品名称</td>
     <td>商品价格</td>
      <td>购买数量</td>
       <td>删除</td>
  </tr>

  
  <c:forEach items="${cart.items }" var="ci">
  <tr>
   <td>${ci.productId }</td>
   <td>${ci.pname }</td>
   <td>${ci.price }</td>
   <td>${ci.count }</td>
   <td>
<a href="#" onclick="deleteItem()"> 删除 </a><img src="img/del.gif" width="14px" height="14px"/>
   </td>
   
   
  </tr>
  </c:forEach>
</table>
<button type="submit" value="提交"style="width: 50px;height: 30px;margin-left: 600px;">确定</button>
</form>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
  <style type="text/css">
    body {
    }
    table {
     border-collapse:collapse;
     border:1px solid gainsboro;
    }
   
    td {
      border:1px solid gainsboro;
      
    }
    select {
    	width: 180px;
    }
   </style>
   <script type="text/javascript">
   function deleteItem() {
		var selectFlags = document.getElementsByName("selectFlag");
			var num = 0;
			var j = 0;
			for(var i=0; i<selectFlags.length; i++){
				if(selectFlags[i].checked == true){
					j=i;
					num++;
				}
			}
			
			if(window.confirm("你确定要删除吗?")){
				window.self.location = "delcate?id=" + selectFlags[j].value;
			}
	}
   </script>
<body>

</body>
</html>