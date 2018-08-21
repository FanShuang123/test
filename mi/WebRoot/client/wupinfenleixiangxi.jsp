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
	background:#EBECED;
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

#goods_list{outline:0px solid #FF0000;background:#EBECED;}
#goods_list .centerNum20150618{}
#goods_list .centerNum20150618 .goods_content{
	padding:0em;
	background:#FFF;
	margin:1em;
	border:1px solid #CCC;
}

#goods_list .centerNum20150618 .goods_content .g_info{
	padding:1em;
	border:1px solid #CCC;
	border-style:none none solid none;
}
#goods_list .centerNum20150618 .goods_content .g_info table{
	width:100%;
	
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
	font-size:1.8em;
	color:#FC6500;
}
#goods_list .centerNum20150618 .goods_content .g_info .help{
	outline:0px solid #FF0000;
	color:#999;
	font-size:1.4em;
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

.pcUrl{
	padding:1em 0px 1em 0em;
	font-size:1.4em;
	text-align:center;
	background:#f4f4f4;
	border:1px solid #FF0000;
	border-style:none none solid none;
	color:#FF0000;
}
.download{
	margin:0em;
	padding:0em;
	border:1px solid #626262;
	background:#626262;
}
.download  img{
	width:100%;
}


</style>
</head>
<body>

<div id="indexNum02">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="index.htm" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">xxx物品名称</span></center>
		<div class="right">
			<a href="" class="a1 cart" title="购物车"></a>
		</div>
	</div>
</div>
<div id="goods_list">
	<div class="centerNum20150618">
		<ul>
			<li class="goods_content">		
				<div class="g_info" onclick="location.href='goods_list2.htm';">
					<table>
						<tr>
							<td width=1><img src="common/images/note180.jpg" /></td>
							<td>
								<span class="s_name">红米Note 4G双卡版</span>
								<span class="money">￥699元</span>
								<br /><br />
								<span class="help">5.5英寸大屏，支持4G，双卡双待</span>
							</td>
						</tr>
					</table>
				</div>
				<div class="buy clearfix">
					<div class="buy_ok">直接购买</div>
					<div class="buy_cart">加入购物车</div>
				</div>
			</li>
			<li class="goods_content">		
				<div class="g_info">
					<table>
						<tr>
							<td width=1><img src="common/images/note180.jpg" /></td>
							<td>
								<span class="s_name">红米Note 4G双卡版</span>
								<span class="money">￥699元</span>
								<br /><br />
								<span class="help">5.5英寸大屏，支持4G，双卡双待</span>
							</td>
						</tr>
					</table>
				</div>
				<div class="buy clearfix">
					<div class="buy_ok">直接购买</div>
					<div class="buy_cart">加入购物车</div>
				</div>
			</li>
			<li class="goods_content">		
				<div class="g_info">
					<table>
						<tr>
							<td width=1><img src="common/images/note180.jpg" /></td>
							<td>
								<span class="s_name">红米Note 4G双卡版</span>
								<span class="money">￥699元</span>
								<br /><br />
								<span class="help">5.5英寸大屏，支持4G，双卡双待</span>
							</td>
						</tr>
					</table>
				</div>
				<div class="buy clearfix">
					<div class="buy_ok">直接购买</div>
					<div class="buy_cart">加入购物车</div>
				</div>
			</li>
		</ul>
	</div>
	<div class="pcUrl">切换到电脑版</div>
	<div class="download"><img src="common/images/icon_s_05.png" /></div>
</div>


</body>
</html>


