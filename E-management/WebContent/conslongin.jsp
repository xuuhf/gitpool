<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<!--<link rel="stylesheet" href="css/login.css" />-->
	<script type="text/javascript">
		function login(){
			var username = document.getElementById("username").value;
			if(username==""||username==null){
				alert("用户名不能为空");
				return;	
			}
			var password = document.getElementById("password").value;
			if(password==""||password==null){
				alert("密码不能为空");
				return;
			}
			if(isNaN(password)){
				alert("请输入数字");
				return;
			}
			loginFrom.submit();
		}
		
	</script>
	<body background="img/14906736174487.jpg" style="background-repeat: no-repeat;">
		
		<form name="loginFrom" action="judjeServlet" method="post">
		<div class="main" style="width: 400px;height: 400px;text-align: center; margin-left: 550px;margin-top: -30px">
			<div class="title"style="width: 400px;height: 120px;">
				
			</div>
			<div class="user" >
				<ul style="list-style: none;  margin-right: 40px">
					<li style="margin-top: -30px;margin-right: 220px;">用户名</li>
					<li ><input  id="username" name="username" style="height: 35px;width: 300px;border-radius: 10px;border: 1px solid #f43499;margin-top: 20px;"  /> </li>
				</ul>
			</div>
			<div class="password" >
				<ul style="list-style: none;margin-right: 40px;">
					<li style="margin-right: 230px;">密码</li>
					<li ><input id="password"  name="password" type="password" style="height: 35px;width: 300px;border-radius: 10px; border: 1px solid #f43499;margin-top: 20px;" /> </li>
				</ul>
			</div>
			<div class="motion">
			<ul style="list-style: none;display:flex; margin-left:100px;margin-top:20px">
			<li ><input type="checkbox" name="check" value="1"  /></li>
			<li >下次自动登录</li>
			</ul>
			</div>
			
			<div class="button" >
				<input  id="check" value="提交" onclick="login()" type="button" style="width: 300px;height: 38px;color:white;border-radius: 10px; text-align: center;margin-top:10px;border: 1px solid #f43499;background-color: #f43499;"  / >
				<br />
				<span>${err }</span>
			</div>
			
		</div>
	</form>
			
			
		
	
	
		
		
		
		
	</body>
</html>
