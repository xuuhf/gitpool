<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	
	<body>
		<div class="main" style="width: 600px;height: 220px;border: 1px solid aquamarine;">
			<div class="up" style="width: 600px;height: 50px; background-color: #F0F8FF;display: flex;">
			<h2 style="color: cornflowerblue;margin-top: 10px;">添加分类</h2>
			<img src="img/叉号.png"style="width: 40px;height: 40px;margin-top: 10px;margin-left: 400px;margin-top: 15px;" onClick="window.close();"/>
			
			</div>	
			  <div class="bet" style="font-size: 20px;text-align: center;">
	      	<form action="AddServlet" method="get">
			分类名称  <input id="cname" name="cname" style="width: 280px;   height: 30px;margin-left: 40px;margin-top: 20px;"/><br />
			上级分类
			         <select id="sel" name="sel" style="width: 285px;height: 35px;margin-top: 10px;margin-left: 38px;">
							<option value="0" >顶级分类</option>
							<c:forEach items="${cate}" var="categ" >
								<option value="${categ.cid}" >
									${categ.cname}
								</option>
							</c:forEach>
						</select><br />
						
						
			<button type="submit" value="确定"style="width: 50px;height: 30px;margin-left: 430px;margin-top: 25px;">确定</button>
             <button type="reset" value="取消"style="width: 50px;height: 30px;">取消</button>		
						
			</form>
			</div>
		</div>
	</body>
</html>
