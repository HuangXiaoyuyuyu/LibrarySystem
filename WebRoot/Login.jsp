<%@ page language="java" import="java.util.*,org.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
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
     <s:form action="Lend">
     	<s:textfield label="姓名" name="login.name" />
     	<s:password label="密码" name="login.password" />
     	<s:select list="#{1:'管理员',0:'学生'}" name="login.role" label="登录选择"></s:select>
     	<s:submit value="提交" />
     </s:form>
     <s:actionerror></s:actionerror>
  </body>
  
</html>
