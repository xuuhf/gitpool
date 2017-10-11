<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
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
	<body>
	 <form id="loginFrom"  action="Dianshang.jsp" method="get">
		<div class="main" style="width: 400px;height: 400px;text-align: center; background-color: #E6E6FA;">
			<div class="title"style="width: 400px;height: 120px;b">
				<h1 style="color: #20B2AA;padding-top: 70px;" >后台管理系统</h1>
			</div>
			<div class="user" >
				<ul style="list-style: none;  margin-right: 40px;">
					<li >用户名</li>
					<li ><input  id="username" name="username" style="height: 25px;width: 200px;"  /> </li>
				</ul>
			</div>
			<div class="password" >
				<ul style="list-style: none;">
					<li >密码</li>
					<li ><input id="password"  name="password"  style="height: 25px;width: 200px; " /> </li>
				</ul>
			</div>
			<div class="motion">
			<ul style="list-style: none;display:flex; margin-left:100px;margin-top:20px">
			<li ><input type="checkbox" name="check" value="1"  /></li>
			<li >下次自动登录</li>
			</ul>
			</div>
			
			<div class="button">
				<input  id="check" value="提交" onclick="login()" style="width: 200px;height: 33px;background-color: #20B2AA;text-align: center;margin-top:10px" / >
			</div>
			
		</div>
	</form>
	</body>
</html>
