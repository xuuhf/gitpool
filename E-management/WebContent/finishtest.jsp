<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<title>边线合并</title>
   <style type="text/css">
    body {
    }
    table {
     border-collapse:collapse;
     border:1px solid gray;
     width: 100%;
    }
   
    td {
      border:1px solid gray;
      
    }
     </style>
	<body>
		<div class="main" ></div>
		
		<div class="list" style="margin-top: 30px;">
		<table>
			<tr  style=" background-color: #F5F5F5; " >
				<td width="50px">id</td>
				<td width="150px">订单状态</td>
				<td width="200px">订单编号</td>
				<td width="150px">下单时间</td>
				<td width="180px">操作</td>
			</tr>
			<c:forEach items="${pm.list }" var="pm" >
			<tr>
				<td width="50px">${pm.id }</td>
				<td width="150px">已完成</td>
				<td width="200px"><a href="ShowServlet?id=${pm.id }">${pm.orderno }</a></td>
				<td width="150px">${pm.ordertime }</td>
				<td width="180px"></td>
			</tr>
			</c:forEach>
		</table>
		</div>
		
		</div>
	</body>
</html>
