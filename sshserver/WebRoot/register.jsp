<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<script type="text/javascript">
		function fa(paw,pawc){
			if(paw==pawc)
				return true;
			else
			return false;
		}
	</script>
  </head>
  
  <body>
   	<form action="user!register" method="post"><br><br>
   		Username:<input type="text" name="username"><br><br>
   		Password:<input type="password" name="password"><br><br>
   		PasswordConfirm:<input type="password" name="passwordConfirm"><br><br>
   		<input type="submit" value="Register">
   	</form>
  </body>
</html>
