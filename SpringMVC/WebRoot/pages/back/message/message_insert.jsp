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
    <form action="pages/back/message/message_insert.action" method="post">
    	消息编号:<input type="text" id="mid" name="mid" value="99"> <br>
    	消息名称:<input type="text" id="title" name="title" value="MLDN"> <br>
    	消息价格:<input type="text" id="price" name="price" value="999.99"> <br>
    	发布日期:<input type="text" id="pubdate" name="pubdate" value="2020-12-22"> <br>
    	消息类型:<input type="text" id="type.TypeTitle" name="type.TypeTitle" value="新闻头条"> <br>
    	<input type="submit" value="提交">
    	<input type="reset" value="重置">
    </form>
  </body>
</html>
