<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<title > 边线合并</title>
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
	<body>
		<form action="SifAddServlet" method="post">
			<table width="700px">
				<tr>
					<td width="185px"  height="40px" style=" background-color: #F5F5F5;">买家账号</td>
					<td style="background-color:#FFFFFF"><input  id="aid" name="aid"/></td>
				</tr>
				<tr>
					<td width="185px"  height="40px" style=" background-color: #F5F5F5;">买家昵称</td>
						<td style="background-color:#FFFFFF"><input  id="nickname" name="nickname"/></td>
				</tr>
				<tr>
					<td width="185px"  height="40px" style=" background-color: #F5F5F5;">订单金额</td>
						<td style="background-color:#FFFFFF"><input  id="money" name="money"/></td>
				</tr>
				<!--<tr>
					<td width="185px"  height="40px" style=" background-color: #F5F5F5;">最后订单时间</td>
						<td style="background-color:#FFFFFF"><input  id="money" name="money"/></td>
				</tr>-->
				
				
			</table>
			
			<button type="submit" value="确定"style="width: 50px;height: 30px;margin-left: 600px;margin-top: 25px;">确定</button>
			
			
			
		</form>
		
	</body>
</html>
