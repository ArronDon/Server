<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  	<table>
  		<tr>
  			<th>用户ID</th><th>用户名</th><th>用户密码</th>
  		<tr>
  		<s:iterator value="users" var="u" status="rowstatus">
  			<s:if test="#rowstatus.odd == true">
      			<tr style="background: #bfbfbf">
	      			<td><s:property value="id"/></td>
	  				<td><s:property value="username"/></td>
	  				<td><s:property value="password"/></td>
  				</tr>
    		</s:if>
    		<s:else>
      		<tr>
	      		<td><s:property value="id"/></td>
	  			<td><s:property value="username"/></td>
	  			<td><s:property value="password"/></td>
  			</tr>
  			</s:else>
  		</s:iterator>
  	</table>
    <s:debug></s:debug>
  </body>
</html>
