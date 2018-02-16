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
    
    <title>My JSP 'SelectBooks.jsp' starting page</title>
    
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
	 <th>图书ID</th><th>书名</th><th>作者</th><th>价格</th><th>借书时间</th>
	</tr>
	<s:iterator value="#request.list" id="lend">
	<tr>
	<td><s:property value="#lend[0]"/></td>
	<td><s:property value="#lend[1]"/></td>
	<td><s:property value="#lend[2]"/></td>
	<td><s:property value="#lend[3]"/></td>		 	
	<td><s:date name="#lend[4]" format="yyyy-MM-dd"/></td>
	</tr>
	</s:iterator>
</table>

    <s:form action="lendBooks">
    	 
	 
		<td colspan="2">
		  图书ID
		<s:textfield name="lend.bookId" size="15"></s:textfield>
		<br>
		用户ID
		<s:textfield name="lend.readerId"></s:textfield>
		<s:submit value="借书"></s:submit>
		</td>
	 
</tr>
    </s:form>
  </body>
</html>
