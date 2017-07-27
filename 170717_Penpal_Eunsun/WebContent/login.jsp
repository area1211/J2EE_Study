<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="./css/login.css"/>

<div id="login_ui">
<c:set var="state" value="${session}"/>
<c:choose>
	<c:when test="${isAdmin == true}">
		<p>${name}님 반갑습니다!</p>
		<a href="#">로그아웃</a><a href="#">관리설정</a>
	</c:when>
	<c:when test="${isAdmin == false}">
		<p>${name}님 반갑습니다!</p>
		<a href="#">로그아웃</a><a href="#">개인정보</a>
	</c:when>
	<c:otherwise>
	<form method="post" action="login_do">
		<input type="text" name="id" placeholder="아이디"/>
		<input type="password" name="pwd" placeholder="비밀번호"/>
		<input type="submit" value="로그인"/><br>
		<a href="#">아이디찾기 / </a><a href="#">비밀번호찾기</a><a href="#">회원가입</a>
	</form>
	</c:otherwise>
</c:choose>
</div>
