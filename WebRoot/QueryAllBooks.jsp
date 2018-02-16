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
    
    <title>My JSP 'QueryAllBooks.jsp' starting page</title>
    
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
    <table  border="1" align="center" width="570" cellspacing="0"  class="font1" style="width: 569px; ">
	<tr >
	 <th>bookId</th><th>bookname</th><th>author</th><th>restnum</th><th>price</th>
	</tr>
	<s:iterator value="#request.list" id="books">
	<tr>
	<td><s:property value="#books.bookId"/></td>
	<td><s:property value="#books.bookname"/></td>
	<td><s:property value="#books.author"/></td>
	<td><s:property value="#books.restnum"/></td>		 	
	<td><s:property value="#books.price"/></td>
	</tr>
	</s:iterator>
</table>
	
  </body>
</html>
