<%@ page language="java" import="java.util.*,com.web.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-control" content="no-cache" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0,minimal-ui" />   
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>小米-为发烧而生</title>
<link rel="stylesheet" type="text/css" href="common/css/common.css">
<style>
body{
	background:#FFF;
}
#indexNum02 .index-head{
	outline:1px solid #e7e7e7;
	border-style:none none solid none;
	background:#F4F4F4;
	padding:1.2em 0em 1.2em 0em;
	position:relative;
}
#indexNum02 .index-head .s_title{
	font-size:2.365em;
	color:#666;
	outline:0px solid #0033CC;
}
#indexNum02 .index-head .left{
	outline:0px solid #FF0000;
	position:absolute;
	left:1em;
	top:1.2em;
	padding:0em 1em 0em 0px;
}
#indexNum02 .index-head .left .home{
	outline:0px solid #FF0000;
}
#indexNum02 .index-head .left .home .mall{
	width:3em;
	height:3em;
	color: #424242;
	display:inline-block;
	outline:0px solid #FF0000;
	margin-left:1em;
	background:url(common/images/icon_home.png) no-repeat;
	background-size:100% 100%;
}
#indexNum02 .index-head .right{
	outline:0px solid #FF0000;
	position:absolute;
	right:1em;
	top:1.2em;
	padding:0em 1em 0em 0px;
}
#indexNum02 .index-head .right .a1{
	width:3em;
	height:3em;
	display:inline-block;
	margin-left:1em;
	outline:0px solid #FF0000;
	
}
#indexNum02 .index-head .right .user{
	background:url(common/images/icon_03.png) no-repeat;
	background-size:100% 100%;
}
#indexNum02 .index-head .right .cart{
	background:url(common/images/icon_02.png) no-repeat;
	background-size:100% 100%;
}

#goods_list{outline:0px solid #FF0000;background:#FFF;}
#goods_list .centerNum20150618{}
#goods_list .centerNum20150618 .goods_content{
	padding:0em;
	background:#FFF;
	margin:1em;
}

#goods_list .centerNum20150618 .goods_content .g_info{
	padding:1em;
	border:1px solid #f4f4f4;
	border-style:none none solid none;
}
#goods_list .centerNum20150618 .goods_content .g_info table{
	
}
#goods_list .centerNum20150618 .goods_content .g_info   img{
	width:8em;
	height:8em;
}

#goods_list .centerNum20150618 .goods_content .g_info .s_name{
	outline:0px solid #FF0000;
	font-size:1.8em;
	color:#333;
}
#goods_list .centerNum20150618 .goods_content .g_info .money{
	outline:0px solid #FF0000;
	font-size:1.2em;
	color:#999;
}
#goods_list .centerNum20150618 .goods_content .g_info .help{
	outline:0px solid #FF0000;
	color:#999;
	font-size:1.4em;
}
#goods_list .centerNum20150618 .goods_content .g_info .delete{
	position:relative;
}
#goods_list .centerNum20150618 .goods_content .g_info .number{
	position:relative;
}
#goods_list .centerNum20150618 .goods_content .g_info .number table{
	border-collapse:collapse;
}
#goods_list .centerNum20150618 .goods_content .g_info .number td{
	border:1px solid #CCC;
}
#goods_list .centerNum20150618 .goods_content .g_info .number .snum{
	display:inline-block;
	text-align:center;
	font-size:2em;
	width:1.5em;
}
#goods_list .centerNum20150618 .goods_content .g_info .number .t01{
	background:#f4f4f4;
}
#goods_list .centerNum20150618 .goods_content .g_info .number .t02{
	background:#FFF;
	border:0px;
}
#goods_list .centerNum20150618 .goods_content .g_info .number .t03{
	background:#eee;
}
#goods_list .centerNum20150618 .goods_content .g_info .cl{
	font-size:1.6em;
	color:black;
	position:absolute;
	right:0em;
	top:0em;
	background:#eee;
	padding:0.2em;
}
#goods_list .centerNum20150618 .goods_content .buy{
	background:#F3F5F6;
}
#goods_list .centerNum20150618 .goods_content .buy .buy_ok{
	width:49%;
	text-align:center;
	font-size:1.4em;
	padding:1em 0em 1em 0em;
	float:left;
	border:1px solid #CCC;
	border-style:none solid none none;
}
#goods_list .centerNum20150618 .goods_content .buy .buy_cart{
	width:49%;
	text-align:center;
	font-size:1.4em;
	padding:1em 0em 1em 0em;
	float:right;
}

.s_js{
	border-style:solid none none none;
	padding:2em 0em;
	position:relative;
}
.s_js .js_jz{
	font-size:1.4em;
	color:#FF6600;
}
.s_js .js_ok{
	font-size:2em;
	color:#FFF;
	background:#FF6600;
	border-radius:0.2em;
	width:8em;
	text-align:center;
	padding:0.3em 0em;
}

</style>
<script type="text/javascript">
  function add(){
  //window.alert("加");
 var ss= document.getElementById("111");
  
  ss.value=parseInt(ss.value)+1;
  }
   function jian(){
  //window.alert("减");
 var jian= document.getElementById("111");
  
  jian.value=parseInt(jian.value);
  if(jian.value>0){
  jian.value=parseInt(jian.value)-1;
  }else{
  alert("数量不能为负数");
  }
  
  }
  

function message(){
alert("您还未登录,登录以后可以查看购物车");
}

  


</script>

</head>
<body>

<div id="indexNum02">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="index.jsp" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">购物车</span></center>
		<div class="right">
			<a href="" class="a1 cart" title="购物车"></a>
		</div>
	</div>
</div>
<div id="goods_list">
	<div class="centerNum20150618">
		<ul>
			
			<li class="goods_content">		
				<div class="g_info">
					<table width="100%"><c:forEach items="${sessionScope.car.map }" var="map" >
						<tr>
							<td width=1 ><img src="${pageContext.request.contextPath}/image/${map.value.goods.goods_img }" /></td>
							<td><%-- <%Car car=(Car)session.getAttribute("car"); 
							String goods_name=car.getMap().get(1).getGoods().getGoods_name();
							%> --%>
							
							
								<span class="s_name">商品名称:${map.value.goods.goods_name }</span><br />
								<span class="money">售价：${map.value.goods.goods_price }元</span>
								<br /><br />
								<table width="100%">
								<tr>
									<td>
										<div class="delete">
											<div class="number">
												<table>
													<tr>
														<td><a class="snum t01" id="000" onclick="location.href='../carServlet?action=redCar&goods_id=${map.value.goods.goods_id }'">-</a></td>
														<td><input class="snum t02" id="111" type="text" value="${map.value.quantity }" /></td>    
														<td><a class="snum t03" onclick="location.href='../carServlet?action=addCar&goods_id=${map.value.goods.goods_id }'">+</a></td>
													</tr>
												</table>
												
											</div>
											<div class="cl">
												<a href="../carServlet?action=delCar&goods_id=${map.value.goods.goods_id }"  onclick="return confirm('确定删除吗？')">删除</a>
											</div>
										</div>
									</td>
								</tr>
								</table>
								
							</td>
						</tr></c:forEach>
					</table>
				</div>
			</li>
			
		</ul>
	</div>
	<div class="s_js">
		<table width="100%">
			<tr>
				<%-- <td style="padding-left:1em;"><span class="js_jz">可返积分：${car.totalPrice }</span></td>
				<td style="padding-left:1em;"><span class="js_jz">积分可用：${car.totalPrice }</span></td> --%>
				<td style="padding-left:1em;"><span class="js_jz">应付金额：${car.totalPrice }元</span></td>
				<td width=1 style="padding-right:1em;"><div class="js_ok" onclick="location.href='../ordersServlet?action=addOrders'">结算</div></td>
			</tr>
		</table>
		
		
	</div>
</div>


</body>
</html>


