<%@ page language="java" import="java.util.*,com.web.vo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modCategory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>
 
  
   <form action="categoryServlet?action=modCategory&id=${category.cat_id }" method="post">
			cat-id:<input type="text" name="cat_id" value="${category.cat_id }"><br>
			cat_name:<input type="text" name="cat_name" value="${category.cat_name }"><br>
			cat_desc:<input type="text" name="cat_desc" value="${category.cat_desc }"><br>
			
			
			
			<input type="submit" value="修改">
			<input type="reset" value="重置">
		</form>
  
  
  
  
  </center>
  </body>
</html>
