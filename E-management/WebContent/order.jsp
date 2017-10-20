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
		<form action="AddOrderServlet" method="post">
	
		<table style="width: 1000px; height: 200px; border: 1px solid gainsboro ;">
				<tr>
					<td style="background-color: #E6E6FA;">订单信息</td>
					<td style="background-color: #E6E6FA;"></td>
				</tr>
				<tr>
					<td>收货人姓名:</td>
					<td><input name="name"/></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input name="phone"/></td>
				</tr>
				<tr>
					<td>支付方式：</td>
					<td>在线支付：<input type="radio" name="yes" value="1"/>
						      货到支付：<input type="radio" name="yes" value="1"/></td>
				</tr>
				<tr>
					<td>地址:</td>				
					<td>省：<select id="Select1" name="sel1"></select>
						市：<select id="Select2" name="sel2"></select>
						区：<select id="Select3" name="sel3"></select>
					</td>

				</tr>
				<tr>
				<td>详细地址</td>
				<td><input name="addr"/></td>
				</tr>
				
			</table>
			<table style="width: 1000px; height: 110px; border: 1px solid gainsboro ;">
				<tr>
					<td style="background-color: #E6E6FA;">备注信息</td>
				</tr>
				<tr>
					<td><input  style="width: 990px; height: 60px;" value="添加信息" onfocus="if(value=='添加信息') {value=''}" onblur="if (value=='') {value='添加信息'}" name="mask"    />    </td>
				</tr>
				
			</table>
			
			
			
			<table style="width: 1000px; height: 30px; border: 1px solid gainsboro ;">
			<tr style="background-color: #E6E6FA;">
				<td >商品编号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>商品单价</td>
			</tr>
			<c:forEach items="${cart.items}" var="ci">
			<tr>
			<input type="hidden" name="pid" value="${ci.productId }" />
			<td><input type="text" name="productid" value="${ci.productId }" /></td>
			<td><input type="text" name="pname" value="${ci.pname }"/></td>
			<td><input type="text" name="count" value="${ci.count }"/></td>
			<td><input type="text" name="price" value="${ci.price }" /></td>
			</tr>
			
			
			</c:forEach>
			</table>
			<button type="submit" value="确定"style="width: 50px;height: 30px;margin-left: 600px;margin-top: 100px;">确定</button>
			</form>
			
	</body>
	<script type="text/javascript" src="js/jsAddress.js" >
		</script>
	<script>
		addressInit('Select1','Select2','Select3');
	</script>
</html>
