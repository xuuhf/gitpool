<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<link rel="stylesheet" href="css/clothes.css" />
	<body>
	
	
	<form action="ShowServlet" method="post">
  	<div class="main">
  		<c:forEach items="${product.list }" var="pro">
			<div class="pic">
				<div class="up">
					<img src="img/${pro.pic }" />
				</div>
				<div class="mid">
					<ul>
						<li>商品名称:${pro.pname }</li>
						<li>商品价格:${pro.price }</li>
					</ul>
				</div>
				<div class="down">
				<ul>
					<li>数量</li>
					<li><input style="width: 50px;"/></li>
					<li><button value="购买">购买</button></li>
				</ul>
				</div>
				
			</div>
			</c:forEach>
		</div>
		
		
		</form> 
		
	</body>
	
	
</html>
