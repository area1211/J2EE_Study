<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 상세보기</title>
<link rel="stylesheet" href="./css/view_post.css"/>
<script src="./js/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(e) {
	$('#postList_btn').click(function(){
		alert("목록돌아가기");
	});
	$('#delete_btn').click(function(){
		alert("삭제하기");
		$('#send_form')[0].reset();
	});
	$('#edit_btn').click(function(){
		alert("수정하기");
		$('#send_form').submit();
	});
	$('#comment_btn').click(function(){
		alert("댓글작성");
	});
});
</script>
<style>

#main-menu{
position:static;
 //z-index:1; 
} 

 #main-login{
position:absolute; 
// z-index:2;
top:50px;
right:100px;
}

#freeboard{
position:static;
}


</style>
</head>
<body>
<div>
	<div id="main-menu">
		<c:import url="navi_bar.jsp">
		</c:import> 
	</div>
	<div id="main-login">
		<c:import url="login.jsp">
		</c:import> 
	</div>
	<div id="freeboard">
	<form method="post" action="#">
		<div class="view_post">
			<div class="board_title">
				<h2>자유게시판</h2>
				<h4>다양한 주제로 자유롭게 이야기해보세요</h4>
				<hr>
			</div>
			<div class="board_section">
			<br><br>
				<table>
					<tr>
						<td class="td_size">글번호</td>
						<td><input type="hidden" id="postNum" class="postNum" name="postNum"/>글번호</td> 
					</tr>
					<tr>
						<td class="td_size">조회수</td>
						<td><input type="hidden" id="hits" class="hits" name="hits"/>조회수</td> 
					</tr>
					<tr>
						<td class="td_size">작성일시</td>
						<td><input type="hidden" id="postDate" class="postDate" name="postDate"/>작성일자</td> 
					</tr>
					<tr>
						<td class="td_size">제목</td>
						<td><input type="hidden" id="title" class="title" name="title"/>제목</td> 
					</tr>
					<tr>
						<td class="td_size">작성자</td>
						<td><input type="hidden" id="id" class="id" name="id"/>아이디</td> 
					</tr>
					<tr>
						<td class="td_size">미디어</td>
						<td><video src="./video/YBM.mp4" preload="1" controls="1" autoplay loop="0" width="865" height="485"></video></td>
					</tr>
					
					<tr>
						<td class="td_size">내용</td>
						<td><textarea id="content" name="content" class="content">내용</textarea></td>
					</tr>
				</table>
				<p>
					이곳에 동철이의 댓글 코드를 붙이세요!
				</p>
				<div class="btnBox_view">
					<input type="button" id="postList_btn" value="목록으로 돌아가기"/>
					<input type="button" id="delete_btn" value="삭제"/>
					<input type="button" id="edit_btn" value="수정"/>
					<input type="button" id="comment_btn" value="댓글작성"/>
				</div>
				<br>
			</div>
		</div>
	</form>
	</div>
</div>
</body>
</html>