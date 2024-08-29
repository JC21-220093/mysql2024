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
<FORM METHOD="GET" ACTION="./result1">
<SELECT NAME="ID">

	<% for (String[] ss : result){ %>
		<OPTION VALUE="<%= ss[1] %>">
		<%= ss[0] %>
		</OPTION>
	<% } %>

</SELECT>
<INPUT TYPE="SUBMIT" VALUE="絞り込む"/>
</FORM>
</body>
</html>