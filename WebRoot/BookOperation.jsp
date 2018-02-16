<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BookOperation.jsp' starting page</title>
    
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
   <s:form action="book" >
   <table>
   		<tr>
   			<td>
   				<table border="1" width="300" cellspacing=1 class="font1">
   					<tr align="center">图书管理</tr>
  					<tr><s:textfield name="books.bookId" label="图书Id" /></tr> 
					<tr><s:textfield name="books.bookname" label="图书名称" /></tr>
					<tr><s:textfield name="books.author" label="作者" /></tr>
					<tr><s:textfield name="books.restnum" label="剩余数量"></s:textfield></tr>
					<tr><s:textfield name="books.price" label="价格" /></tr>
				</table>
  			</td>
  			<td>
  				<table border="1" width="200" cellspacing=1 class="font1">
	  				<tr>
					<s:submit value="图书追加" method="addBook"></s:submit>
					<br>
					<s:submit value="图书删除" method="deleteBook"></s:submit>
					<br>
					<s:submit value="图书修改" method="updateBook"></s:submit>
					<br>
					
  				</table>
  			</td>
   		</tr>
   </table>
</s:form>
<s:form action="book1"><s:submit value="图书查询"  ></s:submit></s:form>
  </body>
</html>
