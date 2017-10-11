<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<form action="UpdateProServlet" method="get">
<input type="hidden" name="id" value="${c.id }"/>
 <table width="700px" >
					<tr >
						<td width="185px"  height="40px" style=" background-color: #F5F5F5;">商品名称</td>
						<td style="background-color:#FFFFFF"><input value="${c.pname }" id="pname" name="pname"/></td>
						
					</tr>
					<tr >
						<td width="185px" height="40px"style=" background-color: #F5F5F5;">所属类别</td>
						<td style="background-color: #FFFFFF">
							<select style="width:200px"  id="add" name="add">
							<option value="1"  >衣服</option>
						</select>
						<select  >
							<option value="1"   >休闲卫衣</option>
						</select>
						</td>
					</tr>
					<tr >
						<td width="185px"  height="40px"style=" background-color: #F5F5F5;">货号</td>
						<td style="background-color: #FFFFFF"><input name="pno" value="${c.pno }" /></td>
						
					</tr>
					<tr >
						<td width="185px" height="40px"style=" background-color: #F5F5F5;">规格</td>
						<td style="background-color: #FFFFFF">
							<select >
							<option value="衣服" >衣服尺码</option>
						</select>
						</tr>
					<tr >
						<td width="185px"  height="40px"style=" background-color: #F5F5F5;">上传照片</td>
						<td style="background-color:#FFFFFF"><input type="file" name="pic" value="${c.pic }"></input></td>
						</tr>
						<tr >
						<td width="185px"  height="40px"style=" background-color: #F5F5F5;">商品价格</td>
						<td style="background-color: #FFFFFF"><input  name="price" value="${c.price }"/></td>
					</tr>
					<tr >
						<td width="185px"  height="40px"style=" background-color: #F5F5F5;">点击数</td>
						<td style="background-color: #FFFFFF"><input name="hits"  /></td>
					</tr>
					<tr >
						<td width="185px"  height="40px"style=" background-color: #F5F5F5;">是否推荐</td>
						<td style="background-color:#FFFFFF">是：<input value="1" type="radio" name="yes1"/>
						      否：<input value="2" type="radio" name="yes1" />
						</td>
						
					</tr>
					<tr >
						<td width="185px"  height="40px"style=" background-color: #F5F5F5;">是否折扣</td>
						<td style="background-color: #FFFFFF">是：<input value="1" type="radio" name="yes2"/>
						      否：<input  value="2" type="radio" name="yes2" />
						</td>
					</tr>
					<tr >
						<td width="185px"  height="40px" style=" background-color: #F5F5F5;">是否上线</td>
						<td style="background-color:#FFFFFF">是：<input value="1" type="radio" name="online"/>
						      否：<input  value="2" type="radio" name="online" />
						</td>
					</tr>
					<tr >
						<td  height="140px"style=" background-color: #F5F5F5;">商品详情</td>
						<td style="background-color:#FFFFFF"><textarea id="edit" name="edit" >${c.pdetail }</textarea>
						</td>
					</tr>
				</table>
				<button type="submit" value="确定"style="width: 50px;height: 30px;margin-left: 430px;margin-top: 25px;">确定</button>
				</form>
</body>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
	<script>
		CKEDITOR.replace("edit");
	</script>
</html>