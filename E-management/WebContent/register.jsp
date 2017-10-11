<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<script type="text/javascript">
		function check1(){
			alert(1);
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
			var repwd = document.getElementById("repwd").value;
			if(repwd==""||repwd==null){
				alter("确认密码不能为空")
				return;
			}if(repwd!=password){
				alter("确认密码与密码不一致")
				return;
			}
			checkFrom.submit();
		}
		</script>
	<body background="img/14906736174487.jpg" style="background-repeat: no-repeat;">
		<form action="Register" method="post" name="checkFrom">
		<div class="main" style="width: 400px;height: 400px;text-align: center; margin-left: 550px;margin-top: -35px">
			<div class="title"style="width: 400px;height: 120px; margin-top: 40px;">
				<ul style="list-style: none;margin-top: 20px;">
					<li>欢迎注册</li>
				</ul>
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
			<div class="password1" >
				<ul style="list-style: none;margin-right: 40px;">
					<li style="margin-right: 230px;">确认密码</li>
					<li ><input id="repwd"  name="repwd" type="password" style="height: 35px;width: 300px;border-radius: 10px; border: 1px solid #f43499;margin-top: 20px;" /> </li>
				</ul>
			</div>
			
			<div class="button" style="margin-right: 190px;" >
				<input  id="check" value="提交" onclick="check1()" style="width: 100px;height: 33px;border-radius: 10px; text-align: center;margin-top:10px;border: 1px solid #f43499;background-color: #f43499;" / >
			</div>
			
		</div>
	</form>
			
			
		</div>	
	
		
	</body>
</html>
