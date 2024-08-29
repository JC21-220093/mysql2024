<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JK3B14</title>
</head>

<%
	ArrayList<String[]> result = (ArrayList<String[]>) request.getAttribute("result");
%>
	
<body>
	<table>
	<% for (String[] ss : result){ %>
		<tr>
			<th><%= ss[1] %></th>
			<td><%= ss[0] %></td>
			<td><%= ss[2] %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>