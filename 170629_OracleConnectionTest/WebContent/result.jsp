<!-- 170629 정인호 -->
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
직원 찾기 결과 <br/>
<c:choose >
<c:when test="${empty result eq false }" >
<table border="1">
	<tr>
		<td>First Name</td>
		<td>${result.firstName}</td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td>${result.lastName}</td>
	</tr>
	<tr>
		<td>Email</td>
		<td>${result.email}</td>
	</tr>
	<tr>
		<td>Phone Number</td>
		<td>${result.phone }</td>
	</tr>
	<tr>
		<td>Hire Date</td>
		<td>${result.hire_date}</td>
	</tr>

</table>
</c:when>
<c:otherwise >
DB에 존재하지 않는 사람입니다!
</c:otherwise>
</c:choose>
</body>
</html>