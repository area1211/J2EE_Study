<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/post.js"></script>
<script type="text/javascript" >

function goWrite(param){
	  if(param != null && param.length != 0){
	   location.href="Front.do?cmd=WriteForward.do";
	  }else{
	   alert("로그인후 글 작성이 가능합니다.");
	   
	  }
}

function logout(){
	location.href="Front.do?cmd=Logout.do";
}

function goDelete(param){
	location.href="Front.do?cmd=PostDelete.do&post_id="+param;
}
</script>

<link rel="stylesheet" href="css/indexStyle.css" />
<link rel="stylesheet" href="css/btnStyle.css" />
<link rel="stylesheet" href="css/article.css" />

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
		<h1>게시판제목</h1>
		<h4>게시판 한줄 설명</h4>
	</div>
	<div class="middleMenu">
		<input id="write" class="write2" type="button" value="글쓰기" />&nbsp;&nbsp;
		<input type="button" value="답글" />
		<c:if test="${detail.nickname eq nickname}" >
			<input type="button" id="modify" value="수정" />
			<input type="button" id="delete" value="삭제" onclick="goDelete('${detail.id}');" />
		
		</c:if>
		
	</div>
	<div class="postList">
		<div>${detail.title}</div>
		<div>${detail.nickname}&nbsp;조회${detail.hits}&nbsp;추천${detail.good}&nbsp;${detail.date}</div>
		<div class="postBody">${detail.body}</div>
	</div>
	<div class="paging">
		<a href="#">앞글</a>
		<a href="Front.do?cmd=BoardList">목록</a>
		<a href="#">뒷글</a>
	</div>

</article>
</body>
</html>