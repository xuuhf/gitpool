<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List"%>
<%@ page import="com.neusoft.entity.Cate" %>
<%@ page import="com.neusoft.entity.PageModel" %>                           



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<link rel="stylesheet" href="css/category.css" />
	<script type="text/javascript">
		function modifly(){
			var selectFlags = document.getElementsByName("selectFlag");
			//统计选择的个数
			var count = 0;
			var j = 0;
				for(var i=0; i<selectFlags.length; i++){
					//判断是否被选中
					if(selectFlags[i].checked){
						j = i;
						count++;
					}
				}
				if(count == 0){
					alert("至少选择一个修改对象");
					return;
				}
	
				if(count > 1){
					alert("一次只能修改一个");
					return;
				}
			
			window.self.location = "ShowModiflyCate?cid=" + selectFlags[j].value;
		}
		
		function deleteItem() {
			var selectFlags = document.getElementsByName("selectFlag");
				var num = 0;
				var j = 0;
				for(var i=0; i<selectFlags.length; i++){
					if(selectFlags[i].checked == true){
						j=i;
						num++;
					}
				}
				if(num == 0){
					alert("至少选择一个删除对象");
					return;
				}
				if(window.confirm("你确定要删除吗?")){
					window.self.location = "delcate?cid=" + selectFlags[j].value;
				}
		}
		
	  	//function topPage() {
		//	window.self.location = "PagemodelServlet?pageNo=1";
			
		//}
		
		//function previousPage() {
			//window.self.location = "PagemodelServlet?pageNo=";
		//}
		
		//function nextPage() {
		//	window.self.location = "PagemodelServlet?pageNo=";
		//}
		
		//function bottomPage() {
			//window.self.location = "PagemodelServlet?pageNo=";
		//}
		
		function add(){
			window.self.location ="BypidServlet";
		}
		
	</script>
	<body>
	
	<%
  PageModel<Cate> pagemodel = (PageModel<Cate>)request.getAttribute("cate");
	//System.out.println(pagemodel);
  List<Cate> catelist = pagemodel.getList(); 
%>
            <a href="#">
			<input class="addC" onclick="add()" type="button" value="添加类别" />
			</a>
		<form action="/del" method="post">
			
			<table>
				<tr style="background-color: aliceblue;">
					<td>
					<input type="checkbox" />
					</td>
					<td>
						编号
					</td>
					<td>
						类别名称
					</td>
					<td>
						父id
					</td>
					<td>
						操作
					</td>
				</tr>
				<%
					for(int i=0;i<catelist.size(); i++){
					Cate cate = catelist.get(i);	
				%> 
				
				
				<tr>
					<td>
					<input type="checkbox" name="selectFlag" value="<%=cate.getCid() %>" />  
					</td>
					<td id = "cid">
						 <%=cate.getCid() %> 
					</td>
					<td>
						 <%=cate.getCname() %> 
					</td>
					<td>
						 <%=cate.getPid()  %> 
					</td>
					<td>
						<a href="#" onclick="modifly()"> 修改 </a><img src="img/upd.gif" width="14px" height="14px"/><a href="#" onclick="deleteItem()"> 删除 </a><img src="img/del.gif" width="14px" height="14px"/>
					</td>
						
				</tr>
				
				 <% } %> 
				
			</table>
			
				 <div style="margin-left:130px" >
				共<%=pagemodel.getTotalPageNo() %>条记录<%=pagemodel.getPageNo() %>/<%=pagemodel.getTotalPageNo() %>页
				&nbsp;<a href="PagemodelServlet?pageNo=1" >首页</a> 
				<a href="PagemodelServlet?pageNo=<%=pagemodel.getPageNo()-1==0?1:pagemodel.getPageNo()-1 %>" >上一页</a>&nbsp;
				<a href="PagemodelServlet?pageNo=<%=pagemodel.getPageNo()+1>pagemodel.getTotalPageNo()?pagemodel.getPageNo():pagemodel.getPageNo()+1 %>" >下一页</a> 
				<a href="PagemodelServlet?pageNo=<%=pagemodel.getTotalPageNo() %>" >尾页</a>
				&nbsp;第<select onChange="if(!isNaN(this.value)){window.self.location = 'PagemodelServlet?pageNo=' + this.value }">
            	if(isNaN(this.value)){location='page?pageNo=this.value'}}this.disabled='disabled'   window.self.location = "page?pageNo=";-->
			  	<%
			  	  int totalPageNo=pagemodel.getTotalPageNo();
			  	for(int i =1; i<totalPageNo;i++){
			  		if(pagemodel.getPageNo()==(i+1)){ %>       		   	
        		    <option value="<%=i+1 %>" selected="selected"><%=(i+1)%></option>
        		  <%  }else { %>
        			  <option value="<%=i+1 %>" ><%=(i+1)%></option>
        		 
        		 <% 	
        			 }
			 	 }
			  	%> 
  

	</select>页
		</div>
		</form>
	</body>
</html>
