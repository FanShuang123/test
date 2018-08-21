<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>管理员登录</title>
<link href="images/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div id="login">
	     <div id="top">
		      <div id="top_left"><img src="images/login_03.gif" /></div>
			  <div id="top_center"></div>
		 </div>
		 
		 <div id="center">
		      <div id="center_left"></div>
			  <div id="center_middle">
			       <div id="user">Email：
			         <input type="text" autocomplete="off" name="email" id="em"/>
			       </div>
				   <div id="password">密 码：
				     <input type="password" name="pwd" id="pwd"/>
				   </div>
				   <div id="code">验证码：
				     <input type="text" autocomplete="off" name="code" id="cod" onFocus="showCode();" onclick="showCode()" />
				   </div>	   
				   <div id="btn">
						<img src="images/img.png"/>
						<a href="javascript:login();">登录</a>
						<a href="reg.jsp">注册</a>
				   </div>
					  
			  </div>
			  <div id="center_right"></div>		 
		 </div>
		 <div id="down">
		      <div id="down_left">
			      <div id="inf">
                       <span class="inf_text">版本信息</span>
					   <span class="copyright">中软创新综合管理系统 2015 v1.0</span>
			      </div>
			  </div>
			  <div id="down_center">
			  	<a href="forget.html">忘记密码！</a>
			  </div>		 
		 </div>
	</div>
</body>
</html>
