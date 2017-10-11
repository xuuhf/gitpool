<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	
	<body>
		<form action="addServlet" method="post">
		<table style="width: 700px; height: 160px; border: 1px solid gainsboro ;">
				<tr>
					<td style="background-color: #E6E6FA;">收货人信息</td>
					<td style="background-color: #E6E6FA;"></td>
				</tr>
				<tr>
					<td>收货人姓名:</td>
					<td><input name="name"/></td>
				</tr>
				<tr>
					<td>地址:</td>				
					<td>省：<select id="Select1" name="sel1"></select>
						市：<select id="Select2" name="sel2"></select>
						区：<select id="Select3" name="sel3"></select>
					</td>

				</tr>
				<tr>
					<td>详细地址:</td>
					<td><input name="addr"/></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input name="phone"/></td>
				</tr>
				
			</table>
			<button type="submit" value="确定"style="width: 50px;height: 30px;margin-left: 600px;margin-top: 25px;">确定</button>
			</form>
	</body>
	<script type="text/javascript" src="js/jsAddress.js" >
		</script>
	<script>
		addressInit('Select1','Select2','Select3');
	</script>
</html>
