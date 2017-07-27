<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="./css/edit_post.css"/>
<script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<%--  	<c:set var="title" value="${title}"/>
	<c:set var="content" value="${content}"/> --%>
	<form method="post" action="editPost_do">
		<div class="edit_post">
			<div class="board_title">
				<h2>자유게시판</h2>
				<h4>다양한 주제로 자유롭게 이야기해보세요</h4>
				<hr>
			</div>
			<div class="board_section">
			<br><br>
				<table>
					<tr>
						<td class="td_size">제목</td>
						<td><input type="text" id="title" class="title" name="title" placeholder="제목을 입력하세요"/>수정양식</td> 
					</tr>
					<tr>
						<td class="td_size">영상</td>
						<td><input type="file" name="attachment" id="attachment" value="첨부" style="width:400px;" onchange="fileInfo(this)"/></td>
					</tr>
					<tr>
						<td class="td_size">내용</td>
						<td><textarea id="content" name="content" class="content"></textarea></td>
					</tr>
				</table>
				<br>
				<div class="btnBox">
					<input type="button" class="cancel" id="cancel" value="취소"/>
					<input type="submit" class="write" id="write" value="수정"/>
				</div>
			</div>
		</div>
	</form>
</body>
</html>