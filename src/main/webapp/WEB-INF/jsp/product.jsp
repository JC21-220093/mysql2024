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
	ArrayList<String[]> product = (ArrayList<String[]>) request.getAttribute("product");
	ArrayList<String[]> product2 = (ArrayList<String[]>) request.getAttribute("product2");
%>
	
<body>
<h1>メーカー表</h1>
<FORM METHOD="GET" ACTION="./item">
<SELECT NAME="ID">

	<% for (String[] ss : product){ %>
		<OPTION VALUE="<%= ss[0] %>">
		<%= ss[1] %>
		</OPTION>
	<% } %>

</SELECT>
<INPUT TYPE="SUBMIT" VALUE="絞り込む"/>
</FORM>
<table border=1>

<h1>商品一覧</h1>
	<% for (String[] ss2 : product2){ %>
		<tr>
			<th><%= ss2[0] %></th>
			<td><%= ss2[1] %></td>
			<td><%= ss2[2] %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>