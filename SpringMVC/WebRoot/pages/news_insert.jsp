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
  </head>
  
  <body>
    <form action="pages/hello/insert.action" method="post" enctype="multipart/form-data">
    	新闻编号:<input type="text" id="nid" name="nid" value="99"> <br>
    	新闻标题:<input type="text" id="title" name="title" value="MLDN"> <br>
    	新闻图片:<input type="file" name="pic"> <br>
    	<input type="submit" value="提交">
    	<input type="reset" value="重置">
    </form>
  </body>
</html>
