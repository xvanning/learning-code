<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String deleteUrl = basePath + "/pages/back/message/message_delete.action";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>

  </head>
  
  <body>
  	<h1>
  		<a href="<%=basePath%>j_spring_security_logout"/>
  	欢迎：${sessionScope['SPRING_SECURITY_CONTEXT'].authentication.principal.username }
  	</h1>
    <h2>
    <security:authentication property="authorities" var="aut"/>
    	${aut}
    </h2>
    
    <%
    	List all = (List) request.getAttribute("allMessages");
    	Iterator iterator = all.iterator();
     %>
     	<table border="1" width="100%">
     		<tr>
     			<td>消息编号</td> 
     			<td>消息名称</td>
     			<td>消息内容</td>
     			<security:authorize ifAnyGranted="ROLE_ADMIN">
     			<td>操作</td>
     			</security:authorize>
     		</tr>
     <%
    	while(iterator.hasNext()){
    		pageContext.setAttribute("msg", iterator.next());
    	
    %>
  		   <tr>
     		   <td>${msg.mid}</td>
     		   <td>${msg.title}</td>
     	 	   <td>${msg.content}</td>
     	 	   <security:authorize ifAnyGranted="ROLE_ADMIN">
     	 	   <td><a href="<%=deleteUrl%>?mid=${msg.mid}"> 删除消息</a></td>
     	 	   </security:authorize>
     	   </tr>
    <%
    	}
    %>
    </table>
    
  </body>
</html>
