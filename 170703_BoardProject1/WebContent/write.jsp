<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/write.js"></script>

<link rel="stylesheet" href="css/indexStyle.css" />
<link rel="stylesheet" href="css/btnStyle.css" />
<link rel="stylesheet" href="css/article.css" />
<link rel="stylesheet" href="css/write.css" />
</head>
<body>
<aside>
	<div id="sideUp">
	<c:if test="${empty sessionScope.nickname}">
		<form action="Front.do?cmd=Login.do" method="post">
			I&nbsp;D&nbsp;<input class="input" type="text" name="id" /><br/>
			PW<input class="input" type="password" name="pwd" /><br/>
			<input type="submit" value="Login"/>
			<input type="button" value="Join"/>
		</form>
	</c:if>
	<c:if test="${!empty sessionScope.nickname }">
		${sessionScope.nickname}님 안녕하세요!<br/>
		<input type="button" value="Logout"/>
	</c:if>
	</div>
	<div id="boardMenu">
		<input id="board1" class="ClassName" type="button" value="Soccer"/><br/><br/>
		<input id="board2" class="ClassName" type="button" value="Basketball"/><br/><br/>
		<input id="board3" class="ClassName" type="button" value="Baseball"/>
	</div>

</aside>
<article>
	<div class="title">
		<h1>글쓰기</h1>
		<hr/>
	</div>
	<div class="middleMenu">
		<select id="select">
			<option value="soccer">축구게시판</option>
			<option value="basket">농구게시판</option>
			<option value="base">야구게시판</option>
		</select>
		&nbsp;
		<select>
			<option>말머리없음</option>
		</select>
		
	</div>
	<form action="Front.do?cmd=PostUpload.do" method="post">
	<div class="postList">
		<input type="text" class="p_title" name="p_title" placeholder="제목을 입력해주세요."/><br/>
		<textarea name="p_body" rows="10" cols="100" placeholder="본문을 입력해주세요."></textarea>
	
	</div>
	<div class="paging">
		<input id="confirm" type="submit" value="확인"/>
		<input id="cancel" type="button" value="취소"/>
	</div>
	</form>

</article>
</body>
</html>