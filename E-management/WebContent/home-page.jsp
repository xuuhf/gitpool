<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<link rel="stylesheet" href="css/home-page.css" />
	<body>
		<div class="main">
			<div class="banner">
				<div class="logo">
					<img src="" />
				</div>
				<div class="header">
					<ul>
					<li><a href="#" style="text-decoration: none;">首页</a></li>
					<li><a href="conslongin.jsp" style="text-decoration: none;">登录</a></li>
					<li><a href="register.jsp" style="text-decoration: none;">注册</a></li>
					<li><a href="#" style="text-decoration: none;">购物车</a></li>
					<li>联系我们</li>
					</ul>
					
				</div>
			</div>
			<div class="down">
           <div class="down-left">
           	<ul>
           		<li onclick="clothes()">衣服</li>
           		<li onclick="applicances()">家电</li>
           		<li onclick="living()">生活用品</li>
           		
           	</ul>
           </div>
            	<div class="down-right">
            		<iframe src="ShowCateServlet?cid=4" id="ifram" name="ifram" style="width: 85%; height: 600px;"></iframe>
            			
            		
            	</div>
            </div>				
				
				
			</div>
			
			
			
		</div>
		
		
	</body>
	
	<script>
		function clothes(){
			var ifram = document.getElementById("ifram");
			ifram.setAttribute("src","ShowCateServlet?cid=4");
		}
		function applicances(){
			var ifram = document.getElementById("ifram");
			ifram.setAttribute("src","ShowCateServlet?cid=1");
		}
		function living(){
			var ifram = document.getElementById("ifram");
			ifram.setAttribute("src","ShowCateServlet?cid=2");
		}
		
		
	</script>
</html>
