<%@ page language="java" import="java.util.*,com.web.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	position:relative;
}
#goods_list .centerNum20150618 .goods_content .g_info table{
	
}
#goods_list .centerNum20150618 .goods_content .g_info .g_buttonImg{
	width:3em;
	height:3em;
	position:absolute;
	right:1em;
	top:2em;
	z-index:1;
	color:#999;
	outline:0px solid #FF0000;
	background:url(common/images/icon_s_06.png) no-repeat;
	background-size:100% 100%;
}
	
#goods_list .centerNum20150618 .goods_content .g_info   img{
	width:8em;
	height:8em;
}

#goods_list .centerNum20150618 .goods_content .g_info .s_name{
	outline:0px solid #FF0000;
	font-size:1.8em;
	color:#999;
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
	font-size:2em;
	color:#eee;
	position:absolute;
	right:0em;
	top:0em;
	background:#eee;
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
	border:1px solid #CCC;
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
</head>
<body>

<div id="indexNum02">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="index.jsp" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">待付款订单列表</span></center>
		<div class="right">
			<a href="" class="a1 cart" title="购物车"></a>
		</div>
		<center><a href="../ordersServlet?action=queryOrdersByUserAndOrderByOrd_status&orderBy=1">降序</a>　　　　
				<a href="../ordersServlet?action=queryOrdersByUserAndOrderByOrd_status&orderBy=2">升序</a></center>
	</div>
</div>
<div id="goods_list">
	<div class="centerNum20150618">
		<ul>
			<c:forEach items="${sessionScope.ordersList}" var="orders">
			<li class="goods_content" onclick="location.href='../ordersServlet?action=queryOneOrdersById&ord_id=${orders.ord_id}'" >		
				<div class="g_info">
					<table width="100%">
						<tr>
							<td width=1><img src="common/images/note180.jpg" /></td>
							<td>								
									<span class="s_name">下单日期：${orders.ord_time }</span><br /><br />
									<span class="money">总金额：${orders.ord_totalPrice }元&nbsp;&nbsp;&nbsp;</span>
									<span class="money" onclick="location.href='../ordersServlet?action=queryOneOrdersById&ord_id=${orders.ord_id}'">点此支付&nbsp;&nbsp;</span>
									<br />
							</td>
						</tr>
					</table>
					
				</div>
			</li>
			
			
			</c:forEach>
		</ul>
	</div>
	
</div>
	<br /><br /><br /><br />

</body>
</html>


