var arr_manage = ["商品管理","订单管理","前台管理","会员管理"]
var arr_account = [{"name":"商品列表","src":"Pro_PagemodelServlet"},{"name":"商品类别维护","src":"PagemodelServlet"},{"name":"商品规格属性","src":"Rule_PagemodelServlet"}];
var arr_security= [{"name":"订单列表","src":"finishtest.html"},{"name":"订单详细","src":"waitting.html"}];
var arr_announ = [{"name":"买家信息","src":"PageModelServlet"}];
var arr_menu = [{"name":"会员管理","src":"SifPageModelServlet"}];

var arr = [arr_account,arr_security,arr_announ,arr_menu];

function _onload(){
	var left_main = document.getElementById("left_main");
	for (var i=0;i<arr_manage.length;i++) {
		 var _div = document.createElement("div");
		 var _div_p = document.createElement("div");
		 var _div_m = document.createElement("div");
		 
		 
	 	 var _div_style="width:150px;height:30px;display:flex;";
		 _div.setAttribute("style",_div_style);
		 
		  left_main.appendChild(_div);
		
		 _div_p.setAttribute("class","picture-bot");
		 _div_p.setAttribute("id","d"+i);
		 _div_p.setAttribute("onclick","change(this)");
		 
		 _div.appendChild(_div_p);
		 _div.appendChild(_div_m);
		_div_m.setAttribute("class","manage");
		
		 var _div_m_text = document.createTextNode(arr_manage[i]);
		
		 _div_m.appendChild(_div_m_text);
		 
		var _div_down = document.createElement("div");
		var _div_down_style = "height:"+(arr[i].length*30)+"px;overflow:hidden;transition: height 1s;";
		var _div_iframe = document.createElement("iframe")
		
		
		_div_down.setAttribute("id","d"+i+"a");
		_div_down.setAttribute("onclick","changeon");
		_div_down.setAttribute("style",_div_down_style); 
		 var _ul = document.createElement("ul"); 
		 _ul.setAttribute("id","d"+i+"b");
		 var _ul_style = "color:white;width:150px;list-style:none;text-align:center;"
		 _ul.setAttribute("style",_ul_style);
		 _div.appendChild(_ul);      
		 left_main.appendChild(_div);
		
		 
		 for(var j=0; j<arr[i].length; j++){
		 	 var _li = document.createElement("li");
		 	 
		     var _li_style = "width:150px;height:30px;"
		     _li.setAttribute("style",_li_style);
		     _ul.appendChild(_li)
		 
		 	var _li_text = document.createTextNode(arr[i][j].name);
		 	_li.setAttribute("onclick","srcChange(this)");
		 	_li.setAttribute("title",arr[i][j].src);
		 	_li.appendChild(_li_text);
		 	_ul.appendChild(_li);
		 }
		 //left_main.appendChild(_ul);
		 _div_down.appendChild(_ul);
		 left_main.appendChild(_div_down);
	}
	
}
function change(obj){
   var id = obj.id+"a";
   var id_ul = obj.id+"b";
   var ida =  document.getElementById(id);
   var idb = document.getElementById(id_ul).childNodes.length;
// alert(ida.style.height);
// alert(idb)
   if(ida.style.height == (idb*30)+"px"){
   		ida.setAttribute("style","height:"+0+"px;overflow:hidden;transition: height 1s");
   }else{
   		ida.setAttribute("style","height:"+(idb*30)+"px;overflow:hidden;transition: height 1s");
   }

   
}


function srcChange(obj){
	//obj.title;
	var ifr = document.getElementById("iframe");
	ifr.src=obj.title;
}
