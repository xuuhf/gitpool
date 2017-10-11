<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
		<div class="addgoods" style="width: 600px;height: 450px; border: 1px solid aquamarine;">
			<div class="up" style="width: 600px;height: 70px; background-color: #F0F8FF;display: flex;">
			<h2 style="color: cornflowerblue;">添加规格商品</h2>
			<img src="img/叉号.png"style="width: 40px;height: 40px;margin-left: 400px;margin-top: 15px;" onClick="window.close();"/>
			
			</div>	
	      <div class="bet" style="font-size: 20px;text-align: center;">
	      	<form action="Rule_updateServlet" method="get">
	      	<input type="hidden" name="id" value="${c.id }">
		商品编号  <input id="pno" name="pno"   style="width: 280px;   height: 30px;margin-left: 40px;"/><br />
		
		尺寸<input  id="size" name="size" style="width: 280px;   height: 30px;margin-left: 40px;margin-top: 30px;""/>
		
			 <button type="submit" value="确定"style="width: 60px;height: 40px;margin-top: 35px;margin-left: 250px;">确定</button>
             <button type="reset" value="取消"style="width: 60px;height: 40px;margin-top: 35px;">取消</button>

			</form>
		
		</div>	
			
			
			
			
		</div>
</body>
</html>