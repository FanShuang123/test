﻿<%@ page language="java" import="java.util.*,com.web.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="right_top">
		<div id="img" onclick="openc()">
			<img src="images/close.gif" />
		</div>
		<span id="spanco" class="imgtext" onclick="openc()">关闭左栏</span>
		
		<span class="imgtext2"></span>
		<div class="weather">
			<marquee id="weather_marquee" direction="left" scrollamount="3" onmouseover="this.stop()" onmouseout="this.start()">
				欢迎登录....
			</marquee>			 
		</div>
		
		
		<div id="loginout">
			<div id="loginoutimg">
				<img src="images/loginout.gif" />
			</div>
			<span class="logintext" onclick="window.location.href='xxx'">退出系统</span>
		</div>
	</div>
	
</body>
</html>
<script type="text/javascript">
	var menu=window.parent.parent.document.getElementsByTagName("frameset")[1]; 
	var spanco = document.getElementById("spanco");
	var img = document.getElementById("img");
	
	function openc(){
		if (spanco.innerHTML =="关闭左栏"){
			menu.cols="0,*";
			spanco.innerHTML = "打开左栏";
			img.innerHTML = "<img src=\"images/open.gif\" />";
		}else{
			menu.cols="188,*";
			spanco.innerHTML = "关闭左栏";
			img.innerHTML = "<img src=\"images/close.gif\" />";
		}
		
	}
</script>

