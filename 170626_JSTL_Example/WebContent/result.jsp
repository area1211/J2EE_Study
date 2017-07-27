<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<strong>Movie list:</strong>
<br/><br/>

<table>
	<c:forEach var="movie" items="${movies}" varStatus="movieLoopCount">
		<tr>
			<td>Count: ${movieLoopCount.count} </td>
		</tr>
		<tr>
			<td>${movie}</td>
		</tr>
	</c:forEach>
</table>
<table>
<% String var=null;  %>
<%
	String[] items=(String[])request.getAttribute("movies");
	for(String tmp: items){
		var=tmp;
%>
<tr><td><%= var %></td></tr>
<%} %>
</table>
<hr/>
<c:out value="${tips}" default="null이다링" />
<c:forEach var="num" items="1,2,3,4">
	<c:out value="${num}"/>
</c:forEach>
</body>
</html>