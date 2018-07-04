<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String insertUrl = basePath + "/pages/back/message/message_insert.action";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>

  </head>
  
  <body>
    <form action="<%=insertUrl%>" method="post">
    	新闻编号:<input type="text" id="mid" name="mid" > <br>
    	新闻标题:<input type="text" id="title" name="title" value="MLDN"> <br>
    	新闻内容:<input type="text" id="content" name="content"> <br>
    	<input type="submit" value="提交">
    	<input type="reset" value="重置">
    </form>
  </body>
</html>
