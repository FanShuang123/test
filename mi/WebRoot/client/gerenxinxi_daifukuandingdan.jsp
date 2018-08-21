<%@ page language="java" import="java.util.*,com.web.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-control" content="no-cache" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0,minimal-ui" />   
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>å°ç±³-ä¸ºåç§èç</title>
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
#goods_list .centerNum20150702{}
#goods_list .centerNum20150702 .goods_content{
	padding:0em;
	background:#FFF;
	margin:1em;
}

#goods_list .centerNum20150702 .goods_content .g_info{
	padding:1em;
	border:1px solid #f4f4f4;
	border-style:none none solid none;
	position:relative;
}
#goods_list .centerNum20150702 .goods_content .g_info table{
	
}
#goods_list .centerNum20150702 .goods_content .g_info table .td_left{
	width:20%;
	color:#999;
}
#goods_list .centerNum20150702 .goods_content .g_info table .td_right{
	width:80%;
	color:#999;
	padding:0.2em;
}
#goods_list .centerNum20150702 .goods_content .g_info .g_buttonImg{
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
	
#goods_list .centerNum20150702 .goods_content .g_info   img{
	width:8em;
	height:8em;
}

#goods_list .centerNum20150702 .goods_content .g_info .s_name{
	outline:0px solid #FF0000;
	font-size:1.8em;
	color:#999;
}
#goods_list .centerNum20150702 .goods_content .g_info .money{
	outline:0px solid #FF0000;
	font-size:1.2em;
	color:#999;
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
				<a href="index.htm" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">è®¢åè¯¦æ</span></center>
		<div class="right">
			<a href="" class="a1 cart" title="è´­ç©è½¦"></a>
		</div>
	</div>
</div>
<div id="goods_list">
	<div class="centerNum20150702">
		<ul>
			<li class="goods_content">		
				<div class="g_info">
					<table width="100%">
						<tr>
							<td align="right" class="td_left">è®¢åç¶æï¼</td>
							<td class="td_right">å·²æ¶è´§</td>
						</tr>
						<tr>
							<td align="right" class="td_left">ååæ»ä»·ï¼</td>
							<td class="td_right">
								499å&nbsp;&nbsp;&nbsp;
								ä¼æ ï¼0å&nbsp;&nbsp;&nbsp;
								è¿è´¹ï¼0å&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<tr>
							<td align="right" class="td_left">åºä»éé¢ï¼</td>
							<td class="td_right">
								499å&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</table>
				</div>
			</li>
			<li class="goods_content">		
				<div class="g_info">
					<table width="100%">
						<tr>
							<td align="right" class="td_left">ç©æµä¿¡æ¯ï¼</td>
							<td class="td_right">é¡ºä¸°(åäº¬)</td>
						</tr>
						<tr>
							<td align="right" class="td_left">è¿åå·ï¼</td>
							<td class="td_right">19946464788484</td>
						</tr>						
					</table>
				</div>
			</li>
			<li class="goods_content">		
				<div class="g_info">
					<table width="100%">
						<tr>
							<td align="right" class="td_left">ä¸åæ¥æï¼</td>
							<td class="td_right">2015-01-01 10:44:18</td>
						</tr>
						<tr>
							<td align="right" class="td_left">è®¢åç¼å·ï¼</td>
							<td class="td_right">11504115041150411504</td>
						</tr>	
						<tr>
							<td align="right" class="td_left">æ¶è´§å°åï¼</td>
							<td class="td_right">
								åäº¬å¸æµ·æ·åºä¸åæºè¥¿è·¯8å·ä¸­å³æè½¯ä»¶å­5å·æ¥¼æ±çå¤§å¦
								<br/>xxåç 134****5678
							</td>
						</tr>	
						<tr>
							<td align="right" class="td_left">æ¶è´§æ¶é´ï¼</td>
							<td class="td_right">
								å·¥ä½æ¥éè´§(éç¨åå¬å°å)
							</td>
						</tr>	
						<tr>
							<td align="right" class="td_left">åç¥¨ç±»åï¼</td>
							<td class="td_right">
								ä¸ªäººçº¸è´¨åç¥¨
							</td>
						</tr>	
						<tr>
							<td align="right" class="td_left">åç¥¨æ¬å¤´ï¼</td>
							<td class="td_right">
								ä¸ªäºº
							</td>
						</tr>							
					</table>
				</div>
			</li>
			<li class="goods_content">		
				<div class="g_info">
					<table width="100%">
						<tr>
							<td width=1><img src="common/images/note180.jpg" /></td>
							<td>								
									<span class="s_name">å°ç±³ææº</span><br /><br />
									<span class="money">å®ä»·ï¼699å&nbsp;&nbsp;&nbsp;æ°éï¼1ä¸ª&nbsp;&nbsp;&nbsp;æ»è®¡ï¼499å</span>
									<br />
							</td>
						</tr>
					</table>
					
				</div>
			</li>
			
		</ul>
	</div>
	
</div>
	<br /><br /><br /><br />

</body>
</html>


