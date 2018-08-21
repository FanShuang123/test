<%@ page language="java" import="java.util.*,com.web.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<%
String path = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../../../../common/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<div >
		<div ></div>
		<div >
			<div >
				<ul >
					<li>
						管理
						<ul>
							<li>
								类别
						<ul>
							<li>
								<a class="a" href="addCategory.jsp" target="right">添加类别</a>
							</li>
							<li>
								<a class="a" href="../../categoryServlet?action=showCategory" target="right">管理类别</a>
							</li>
						</ul>
							</li>
							<li>
								商品
								<ul>
							<li>
								<a class="a" href="../../categoryServlet?action=queryCategoryForGoods" target="right">添加商品</a>
							</li>
							<li>
								<a class="a" href="../../goodsServlet?action=showGoods" target="right">管理商品</a>
							</li>
						</ul>
							</li>
							<li>
								用户订单管理
								<ul>
							<li>
								<a class="a" href="../../ordersServlet?action=queryBy" target="right">待付款订单</a>
							</li>
							<li>
								<a class="a" href="../../goodsServlet?action=showGoods" target="right">已付款订单</a>
							</li>
						</ul>
							</li>
						</ul>
					</li>
					
				</ul>
			</div>
		</div>
		<div />
     </div>
</body>
</html>

<script type="text/javascript">
$(function(){
	initHeight();
	$("#globalNav").children().each(function(index){
		var item = $(this);
		var tag_a = item.children().eq(0);
		tag_a.attr("href", "#this");
		var tag_ul = item.children().eq(1);
		if(index == 0) {
			tag_ul.show();
		}
		tag_a.click(function(){
			tag_ul.toggle();
		});
	});
	
	$(".a").click(function(){
		$(".a").css({"color":"black", "font-weight":"normal"});
		$(this).css({"color":"red", "font-weight":"bold"});
	});
})
window.onresize=function() {
	initHeight();
}
function initHeight(){
	$("#left_tree").css("height", document.documentElement.clientHeight-80);
	$("#tree_text").css("height", document.documentElement.clientHeight-80);
}
</script>
