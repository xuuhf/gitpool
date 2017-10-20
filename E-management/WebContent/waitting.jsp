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
	<form action="" method="post">
		<div class="main">
			<!--<div class="order" style="width: 1000px; height: 200px; border: 1px solid gainsboro ;">
				<ul style="list-style: none; ">
					
					<li style="margin-top: 20px;">订单编号</li>
					<li>订单编号</li>
					<li>订单编号</li>
					<li>订单编号</li>
				</ul>
			</div>-->
			<table style="width: 1000px; height: 200px; border: 1px solid gainsboro ;">
				<tr>
					<td style="background-color: #E6E6FA;">订单信息</td>
					<td style="background-color: #E6E6FA;"></td>
				</tr>
				<tr>
					<td>订单编号：</td>
					<td><input name="id" value="${po.oi.orderno }"/></td>
				</tr>
				<tr>
					<td>支付方式：</td>
					<td><input  name="yes" value="1"/>
						   </td>
				</tr>
				<tr>
					<td>下单时间：</td>
					<td><input name="ordertime" value="${po.oi.ordertime }"/></td>
				</tr>
				<tr>
					<td>付款时间：</td>
					<td><input name="paytime" value="${po.oi.paytime }"/></td>
				</tr>
			</table>&nbsp;
			<table style="width: 1000px; height: 160px; border: 1px solid gainsboro ;">
				<tr>
					<td style="background-color: #E6E6FA;">收货人信息</td>
					<td style="background-color: #E6E6FA;"></td>
				</tr>
				<tr>
					<td>收货人姓名:</td>
					<td><input name="name" value="${po.cad.name }"/></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input name="phone" value="${po.cad.phone }"/></td>
				</tr>
				
				<tr>
				<td>详细地址</td>
				<td><input name="addr" value="${po.cad.addr }" /></td>
				</tr>
				
			</table>&nbsp;
			<table style="width: 1000px; height: 160px; border: 1px solid gainsboro ;">
				<tr>
					<td style="background-color: #E6E6FA;">物流信息</td>
				</tr>
				<tr>
					<td>物流公司：&nbsp&nbsp&nbsp&nbsp&nbsp<input />       </td>
				</tr>
				<tr>
					<td>物流单号：&nbsp&nbsp&nbsp&nbsp&nbsp<input />      </td>
				</tr>
				<tr>
					<td><input type="button"value="确认发货" style="margin-left: 105px;"/><a href="#" style="text-decoration: none;">编辑发货信息</a>     </td>
				</tr>
				
			</table>&nbsp;
			<table style="width: 990px; height: 110px; border: 1px solid gainsboro ;">
				<tr>
					<td style="background-color: #E6E6FA;">${oi.mask }</td>
				</tr>
				<tr>
					<td><input  style="width: 990px; height: 60px;" value="添加信息" onfocus="if(value=='添加信息') {value=''}" onblur="if (value=='') {value='添加信息'}"     />    </td>
				</tr>
		</table>&nbsp;
		<table style="width: 1000px; height: 30px; border: 1px solid gainsboro ;">
			<tr style="background-color: #E6E6FA;">
				<td >商品编号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>商品单价</td>
			</tr>
			<c:forEach items="${po.pd}" var="pd">
			<tr>
			<td><input type="text" name="productid" value="${pd.id }" /></td>
			<td><input type="text" name="pname" value="${pd.pname }"/></td>
			<td><input type="text" name="count" value="${pd.count }"/></td>
			<td><input type="text" name="price" value="${pd.totalprice }" /></td>
			</tr>
			</c:forEach>
			
			
			
			
		</div>
			
			
		</table>
		</form>
	</body>
</html>
