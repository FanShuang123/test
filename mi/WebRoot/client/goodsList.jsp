<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goodsList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><center>
    	

		<div style="float: left;border:1px red solid;height:100%;width: 100%">
			<c:forEach items="${page.goodsList }" var="goods" varStatus="i">
				
			  <div style="float:left;width:350px;margin-right: 100px;border:blue double;margin-bottom: 20px">
					<div style="float:left">
						<img src="${pageContext.request.contextPath}/image/${goods.goods_img }" width="100" height="100">
					</div>
					<div style="float:left;width:150px;text-align: left;padding-left: 10px;padding-top: 15px">
						商品名称：${goods.goods_name }<br>
						商品价格：${goods.goods_price }<br>
						商品类别编号：${goods.category.cat_id }<br>
						<a href="${pageContext.request.contextPath }/carServlet?action=addCar&goods_id=${goods.goods_id }">添加购物车</a>
					</div>
			  </div>
		
			  <c:if test="${(i.index+1) % 2 ==0 }">
			  	<div style="clear:both;"></div>
			  </c:if>
			</c:forEach>
		</div>

<div style="clear:both;"></div>
<div style="border:1px red dotted;">
			<c:forEach begin="${1 }" end="${page.totalPageCount }" step="1" var="pageNum">
				<a href="indexServlet?action=queryAll&pageNum=${pageNum }">第${pageNum }页</a>
			</c:forEach>
		</div>
		</center>

  </body>
</html>
