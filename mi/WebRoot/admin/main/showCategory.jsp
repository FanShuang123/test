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
		<h1>管理类别信息</h1>
		<!-- <form action="categoryServlet?action=modCategory" method="post"> -->
		
              
                <table border="1">
                 <tr><th>cat_id</th><th>cat_name</th><th>cat_desc</th><th>||操作||</th></tr>
          
  
       <%     //接值 
                   List<Category> categoryList= (ArrayList<Category>)request.getAttribute("categoryList");
              
                  for(Category category:categoryList){
                  
                    //为什么要给value 赋值?   /////////////////////
                %>    
                
		          	   <tr><td> <%=category.getCat_id() %></td>
		                   <td>  <%= category.getCat_name() %></td>
                           <td>  <%=category.getCat_desc()%></td>
                          
                            
                         <td><a href="categoryServlet?action=queryById&id=<%=category.getCat_id()%>">修改</a>|<a href="deleteUser.jsp">删除</a></td>
                     </tr>    
                        
       <% } %>
 
    </table>
      
  
  </center>
		
		
		
		
	
	
  </body>
</html>
