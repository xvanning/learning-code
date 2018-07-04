<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="myRefersh.js"></script>
  </head>
  
  <body>
  <h1>${param.error==true?"登陆失败，错误的用户名或密码 ！":""}</h1>
  <%
  	if (session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION")!=null){
  		String str = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION").toString();
  		if(str.contains("DisabledException")){
  %>
  		<h3>该用户已经被锁定了，请与管理员联系</h3>
  <%
  		}
  		if(str.contains("BadCredentialsException")){
  			%>		
  		<h3>错误的验证码，请重试</h3>	
 <% 			
  		}
  	}
  %>
    	<form action="<%=basePath%>login" method="post">
    	用户名：	<input type="text" name="j_username" id="j_username"> <br>
    	密&nbsp;码 : <input type="password" name="j_password" id="j_password"> <br>
    	验证码: <input type="text" name="code" id="code"><img src="<%=request.getContextPath() %>/ImageCode" onclick="myRefersh(this)" > <br>
    	<input type="checkbox" name="_spring_security_remember_me" value="true">记住我<br>
    	<input type="submit" value="提交">
    	<input type="reset" value="重置">
    	</form>
  </body>
</html>
