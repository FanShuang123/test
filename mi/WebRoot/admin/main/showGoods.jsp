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
		<h1>管理商品信息</h1>
		

              
                <table border="1">
                 <tr><th>goods_id</th><th>goods_name</th><th>goods_price</th><th>goods_img</th><th>cat_id</th><th>||操作||</th></tr>
          
  
          <c:forEach items="${goodsList }" var="goods">
		
		
		
                
		          	   <tr><td> ${goods.goods_id }</td>
		                   <td>  ${goods.goods_name }</td>
                           <td>  ${goods.goods_price }</td>
                           <td>  ${goods.goods_img }</td>
                           <td>  ${goods.category.cat_id }</td> 
                          
                          <%--   ${goods} --%>
                         <td><a href="goodsServlet?action=queryById&id=${goods.goods_id }">修改</a>|<a href="deleteUser.jsp">删除</a></td>
                     </tr>    
                        </c:forEach>
    
 
    </table>
      
  
  </center>
		
		
		
		         <!--    类别ＩＤ：<input type="text" name="cat_id"><br>     
			类别名称：<input type="text" name="cat_name"><br>
			类别描述：<input type="text" name="cat_desc"><br> -->
			<!-- <input type="submit" value="修改类别">
			<input type="reset" value="重置"> -->
		
	
	
  </body>
</html>
