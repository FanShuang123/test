<%@ page language="java" import="java.util.*,com.web.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modGood.jsp' starting page</title>
    
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
   
      <form action="goodsServlet?action=modGoods&id= ${ goods.goods_id }" method="post">
			goods_id:<input type="text" name="goods_id" value="${goods.goods_id }"><br>
			goods_name:<input type="text" name="goods_name" value="${goods.goods_name }"><br>
			goods_price:<input type="text" name="goods_price" value="${goods.goods_price }"><br>
			goods_img:<input type="text" name="goods_img" value="${goods.goods_img}"><br>
			cat_id:<input type="text" name="cat_id" value="${goods.category.cat_id }"><br>
			<%-- ${goods } --%>
											
			<%-- <% request.getSession().setAttribute("goods",goods); %> --%>
			
			
			<input type="submit" value="修改">
			<input type="reset" value="重置">
		</form>
     
     
    
    
    </center>
  </body>
</html>
