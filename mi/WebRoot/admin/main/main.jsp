<%@ page language="java" import="java.util.*,com.web.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>后台管理</title>
</head>
<frameset rows="60,*" cols="*" frameborder="no" border="0" framespacing="0">
	<frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
	<frameset rows="*" cols="188,*" framespacing="0" frameborder="no" border="0">
		<frame src="left.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame"/>
		<frameset rows="35,*" cols="*">
		  <frame src="right_top.jsp" name="mainFrame" id="mainFrame" scrolling="no"/>
		  <frame src="right.jsp" name="right"/>
		</frameset>
	 </frameset>
</frameset>
	
<noframes> 
	<body>
	</body>
</noframes>
</html>
