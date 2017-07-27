<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table{
	width: 100%;
		border: 1px solid black;
		border-collapse: collapse;
	}
	td	{
		border: 1px solid black;
	}
</style>
</head>
<body>
<table>

	<tr>
		<td>이름</td>
		<td>나이</td>
	</tr>
	<c:forEach var="board" items="${requestScope.list }">
	<tr>
		<td>${board.name}</td>
		<td>${board.age}</td>
	</tr>
	</c:forEach>
</table>
<br>
	<div>
	<c:if test="${startPage!=1 }">
		<a href="Paging">이전</a>
	</c:if>
	<c:forEach var="pageNum" begin="${startPage}" end="${endPage }">
		<c:if test="${pageNum==spage}">
			${pageNum }&nbsp;
		</c:if>
		<c:if test="${pageNum < spage}">
			<a href="namnani?num=${pageNum }">${pageNum}&nbsp</a>
		</c:if>
		<c:if test="${pageNum > spage}">
			<a href="namnani?num=${pageNum }">${pageNum}&nbsp</a>
		</c:if>
	</c:forEach>
	
	<c:if test="${endPage != maxPage }">
		<a href="www.naver.com">다음</a>
	</c:if>
	</div>
</body>
</html>