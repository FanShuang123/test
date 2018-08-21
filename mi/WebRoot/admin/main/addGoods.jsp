<%@ page language="java" import="java.util.*,com.web.vo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addCategory.jsp' starting page</title>
     
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
		<h1>添加商品信息</h1>
		<form action="goodsServlet?action=addGoods" method="post"  enctype="multipart/form-data" >
	       商品名称:<input type="text" name="goods_name" ><br>
                   商品价格:<input type="text" name="goods_price" ><br>
                   商品图片:<input type="file" name="goods_img" ><br>
                   <%-- 商品类别:<select name="cat_id">
               	<%
							List<Category> categoryList = (ArrayList)request.getAttribute("categoryList") ;
							for(Category category : categoryList){
						%>
								<option value="<%=category.getCat_id() %>"><%=category.getCat_name() %></option>
						                                      <!-- option的value属性是后台接的值,前台显示text属性即 -->
						<%                                       /* 正则表达式一直是错的`` */
							}
						%>
						
					</select>  <br> --%>
					商品类别：<select name="cat_id">
    					<c:forEach items="${categoryList}" var="cat">
    					<option value="${cat.cat_id }">${cat.cat_name }</option>
    					</c:forEach>   
    		</select>  <br>
			<input type="submit" value="添加商品">
			<input type="reset" value="重置">	
		</form>
	</center>
  </body>
</html>
