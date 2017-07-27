<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/view_postlist.js"></script>
<link rel="stylesheet" href="./css/view_postlist.css"/>
<title>게시글 목록보기+검색</title>
</head>
<body>
   <br/>
	<div id="div_body">
	<h2>게시판목록보기</h2><hr/>
	<form id="selectmail_form">
	<div id="div_list">
	<table class="list_table">
	<tr id="tr1">
		<th id="th1">번호</th>
		<th id="th2">작성자</th>
		<th id="th3">제목</th>
		<th id="th4">내용</th>
		<th id="th5">조회수</th>
		<th id="th6">발신일</th>
	</tr>
	<c:forEach var="sendMail" items="${list}" varStatus="Listcount">
		<tr>
		<td>${sendMail.postNum}</td>
		<td>${sendMail.writer}</td>
		<td>${sendMail.title}</td>
		<td>${sendMail.postText}</td>
		<td>${sendMail.hits}</td>
		<td>${sendMail.wirteDate}</td>
		</tr>
	</c:forEach>
	</table>
		</div><!-- 리스트 -->
	</form><!-- 삭제할 편지를 선택받는 폼 -->
	<div id="pageForm" class="paging">
        <c:if test="${startPage != 1}">
            <a href="viewPostListServlet.do?page=${startPage-1}&lNum=${lNum}">[이전]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
            <c:if test="${pageNum == spage}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != spage}">
                <a href='viewPostListServlet.do?page=${pageNum}&lNum=${lNum}'>${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${endPage != maxPage }">
            <a href='viewPostListServlet.do?page=${endPage+1}&lNum=${lNum}'>[다음]</a>
        </c:if>
    </div>	
		
	<form id="search_from" action="searchPostServlet.do">
	<table id="search_table">
		<tr>
			<td><select name="search_select">
				<option>전체</option>
				<option>작성자</option>
				<option>제목</option>
				<option>내용</option>
			</select>
			<input type="text" value="검색어입력" name="search_keyword"/>
			<input type="button" value="검색" id="search_btn"/>
			</td>
		</tr>
	</table>
	</form>
	</div><!-- 전체div -->
</body>
</html>